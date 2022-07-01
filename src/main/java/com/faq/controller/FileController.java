package com.faq.controller;

import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/file/")
public class FileController {
    @Value("${upload.path}")
    private String uploadPath;
    /**
     *
     <!DOCTYPE html>
     <html>
     <head>
     <meta charset="utf-8">
     <title>文件上传和下载</title>
     </head>
     <body>
     <form action='http://localhost:8080/file/upload' method='post' enctype='multipart/form-data'>
     <input type='file' name='file'>
     <button type='submit'>上传</button>
     </form>
     </body>
     </html>

     * @param file
     * @return
     */
    @RequestMapping("upload")
    @ResponseBody
    public Map upload (@RequestParam("file") MultipartFile file) throws FileUploadBase.IOFileUploadException{
        // 获取原始名字
        String fileName = file.getOriginalFilename();
        // 获取后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件保存路径
        //String filePath = "d:/upload/";
        String filePath = uploadPath;
        // 文件重命名，防止重复
        fileName = UUID.randomUUID() + fileName;
        Map<String,String> map = new HashMap<>();
        map.put("dataFile",fileName);
        map.put("dataSuffix",suffixName);
        fileName = filePath + fileName;
        // 文件对象
        File dest = new File(fileName);
        // 判断路径是否存在，如果不存在则创建
        if(!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            // 保存到服务器中
            file.transferTo(dest);
            map.put("status","上传成功");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("status","上传失败");
        return map;
    }
    @RequestMapping("download")
    public void download(HttpServletResponse response) throws Exception {
        // 文件地址，真实环境是存放在数据库中的
        File file = new File("D:\\upload\\a.txt");
        // 穿件输入对象
        FileInputStream fis = new FileInputStream(file);
        // 设置相关格式
        response.setContentType("application/force-download");
        // 设置下载后的文件名以及header
        response.addHeader("Content-disposition", "attachment;fileName=" + "asss.txt");
        // 创建输出对象
        OutputStream os = response.getOutputStream();
        // 常规操作
        byte[] buf = new byte[1024];
        int len = 0;
        while((len = fis.read(buf)) != -1) {
            os.write(buf, 0, len);
        }
        fis.close();
    }

}
