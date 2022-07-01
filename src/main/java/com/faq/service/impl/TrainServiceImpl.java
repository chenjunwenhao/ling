package com.faq.service.impl;

import com.faq.entity.Train;
import com.faq.mapper.TrainDao;
import com.faq.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrainServiceImpl implements TrainService {
    @Autowired
    private TrainDao trainDao;
    @Override
    public List<Train> getTrain(Train train){return trainDao.getTrain(train);};
    @Override
    public Train getTrainById(Train train){return trainDao.getTrainById(train);};
    @Override
    public int insertTrain(Train train){return trainDao.insertTrain(train);};
    @Override
    public int updateTrain(Train train){return trainDao.updateTrain(train);};
    @Override
    public int deleteTrain(Train train){return trainDao.deleteTrain(train);};
}
