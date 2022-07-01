package com.faq.mapper;

import com.faq.entity.Video;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VideoDao {
    public List<Video> getVideo(Video video);
    public Video getVideoById(Video video);
    public int insertVideo(Video video);
    public int updateVideo(Video video);
    public int deleteVideo(Video video);
}
