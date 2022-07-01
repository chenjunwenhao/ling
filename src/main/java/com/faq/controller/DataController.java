package com.faq.controller;

import com.faq.entity.Data;
import com.faq.entity.DataDownload;
import com.faq.service.DataDownloadService;
import com.faq.service.DataService;
import com.faq.utils.RedisUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/data")
public class DataController {
    @Value("${upload.path}")
    private String uploadPath;
    @Autowired
    private DataService dataService;
    @Autowired
    private DataDownloadService dataDownloadService;
    @Autowired
    private RedisUtil redisUtil;

    @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder ) {
            SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
            dateFormat.setLenient( false );
            binder.registerCustomEditor( Date.class, new CustomDateEditor( dateFormat, false ) );
    }
    @RequestMapping("/getData")
    public PageInfo<Data> getData(Integer pageIndex,Integer pageSize,Data data){
        //System.out.print(uploadPath);
        List<Data> datalist = new ArrayList<Data>();
        Page<Data> dataPage = PageHelper.startPage(pageIndex,pageSize);
        datalist = dataService.getData(data);//这个全页查询必须在这个PageHelper.startPage下面第一行
        PageInfo<Data> dataPageInfo = new PageInfo<Data>(datalist);
        return dataPageInfo;
    }
    @RequestMapping("/getDataById")
    public Data getDataById(Data data){
        return dataService.getDataById(data);
    }
    @RequestMapping("/save")
    public String save(Data data){
        if(data.getDataId()==null){
            if(dataService.insert(data)==1){
                return "新增成功";
            }
            return  "新增失败";
        }
        int status = dataService.update(data);
        if(status==1){
            return "编辑成功";
        }
        return "编辑失败";
    }
    @RequestMapping("update")
    public String update(Data data){
        int status = dataService.update(data);
        if(status==1){
            return "success";
        }
        return "fail";
    }
    @RequestMapping("delete")
    public String delete(Data data){
        int status = dataService.delete(data);
        if(status==1){
            return "success";
        }
        return "fail";
    }
    @RequestMapping("downloadRank")
    public List<Data> downloadRank(){
        Set<String> downloadRankSet = new HashSet<String>();
        List<Data> dataList = new ArrayList<Data>();
        downloadRankSet =redisUtil.zReverseRange("rank_download",0,9);
        for(String s : downloadRankSet){
            Data data = new Data();
            data.setDataId(Integer.valueOf(s));
            data = dataService.getDataById(data);
            dataList.add(data);
        }
        return dataList;
    }
    @RequestMapping("/dataUpload")
    public Map dataUpload (@RequestParam("file") MultipartFile file){
        //文件名传回前端
        Map dataMap = new HashMap();
         // 获取原始名字
        String fileName = file.getOriginalFilename();
        // 获取后缀名
         String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件保存路径
        //String filePath = "d:/upload/";
        String filePath = uploadPath;
        // 文件重命名，防止重复
        fileName = filePath + UUID.randomUUID() + fileName;
        dataMap.put("dataFile",fileName);
        // 文件对象
        File dest = new File(fileName);
        // 判断路径是否存在，如果不存在则创建
        if(!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            // 保存到服务器中
            file.transferTo(dest);
            dataMap.put("states","上传成功");
            return dataMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        dataMap.put("state","上传失败");
        return dataMap;
    }
    @RequestMapping("/download")
    public void dataDownload(HttpServletResponse response,HttpServletRequest request,Data data) throws Exception {
        // 文件地址，真实环境是存放在数据库中的
        File file = new File(uploadPath+data.getDataFile());
        // 穿件输入对象
        FileInputStream fis = new FileInputStream(file);
        // 设置相关格式
        response.setContentType("application/force-download");
        // 设置下载后的文件名以及header
        String fileName = data.getDataName()+"."+data.getDataSuffix();
        response.addHeader("Content-disposition", "attachment;fileName=" + new String(fileName.getBytes("utf-8"),"ISO8859-1"));
        // 创建输出对象
        OutputStream os = response.getOutputStream();
        // 常规操作
        byte[] buf = new byte[1024];
        int len = 0;
        while((len = fis.read(buf)) != -1) {
            os.write(buf, 0, len);
        }
        System.out.print(data.toString());
        DataDownload dataDownload = new DataDownload();
        dataDownload.setDataId(data.getDataId());
        String ip;
        if(request.getHeader("x-forwarded-for") == null){
            ip= request.getRemoteAddr();
        }else{
            ip=request.getHeader("x-forwarded-for");
        }
        dataDownload.setDownloadIp(ip);
        dataDownloadService.insert(dataDownload);
        redisUtil.zIncrementScore("rank_download",data.getDataId().toString(),1);
        fis.close();
    }
}
