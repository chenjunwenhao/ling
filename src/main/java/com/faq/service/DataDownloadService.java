package com.faq.service;

import com.faq.entity.DataDownload;

import java.util.List;

public interface DataDownloadService {
    public int insert(DataDownload dataDownload);
    public List<DataDownload> getDataDownloadRank();
}
