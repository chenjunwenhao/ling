package com.faq.controller;

import com.faq.entity.Video;
import com.faq.service.VideoService;
import com.faq.utils.RedisUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController {
    @Autowired
    private VideoService videoService;
    @Autowired
    private RedisUtil redisUtil;
    @RequestMapping("/getVideo")
    public PageInfo<Video> getVideo(Video video,Integer pageIndex,Integer pageSize){
        List<Video> videoList = new ArrayList<Video>();
        Page<Video> videoPage = PageHelper.startPage(pageIndex,pageSize);//这个全页查询必须在这个PageHelper.startPage下面第一行
        videoList = videoService.getVideo(video);
        PageInfo<Video> videoPageInfo = new PageInfo<Video>(videoList);
        return videoPageInfo;
    }
    @RequestMapping("/getVideoById")
    public Video getVideoById(Video video){
        return videoService.getVideoById(video);
    }
    @RequestMapping("/save")
    public String save(Video video){
        if(video.getVideoId()==null){
            if(videoService.insertVideo(video)==1){
                return "新增成功";
            }
            return  "新增失败";
        }
        int status = videoService.updateVideo(video);
        if(status==1){
            return "编辑成功";
        }
        return "编辑失败";
    }
    @RequestMapping("/delete")
    public String delete(Video video){
        int isDelete;
        isDelete = videoService.deleteVideo(video);
        if(isDelete==1){
            return "删除成功";
        }
        return "删除失败";
    }
}
