package com.faq.service;

import com.faq.entity.Video;

import java.util.List;

public interface VideoService {
    public List<Video> getVideo(Video video);
    public Video getVideoById(Video video);
    public int insertVideo(Video video);
    public int updateVideo(Video video);
    public int deleteVideo(Video video);
}
