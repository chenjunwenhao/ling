package com.faq.mapper;

import com.faq.entity.DataDownload;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DataDownloadDao {
    public int insert(DataDownload dataDownload);
    public List<DataDownload> getDataDownloadRank();
}
