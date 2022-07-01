package com.faq.service.impl;

import com.faq.entity.DataDownload;
import com.faq.mapper.DataDownloadDao;
import com.faq.service.DataDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataDownloadServiceImpl implements DataDownloadService{
    @Autowired
    private DataDownloadDao dataDownloadDao;

    @Override
    public int insert(DataDownload dataDownload){
        return dataDownloadDao.insert(dataDownload);
    };
    @Override
    public List<DataDownload> getDataDownloadRank(){
        return dataDownloadDao.getDataDownloadRank();
    }
}
