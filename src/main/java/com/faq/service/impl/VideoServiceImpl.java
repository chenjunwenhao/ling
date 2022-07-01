package com.faq.service.impl;

import com.faq.entity.Video;
import com.faq.mapper.VideoDao;
import com.faq.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService{

    @Autowired
    private VideoDao videoDao;

    @Override
    public List<Video> getVideo(Video video){return videoDao.getVideo(video);}
    @Override
    public Video getVideoById(Video video){return videoDao.getVideoById(video);}
    @Override
    public int insertVideo(Video video){return videoDao.insertVideo(video);}
    @Override
    public int updateVideo(Video video){return videoDao.updateVideo(video);}
    @Override
    public int deleteVideo(Video video){return videoDao.deleteVideo(video);}
}
