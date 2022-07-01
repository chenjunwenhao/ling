package com.faq.service;

import com.faq.entity.Train;

import java.util.List;


public interface TrainService {

    public List<Train> getTrain(Train train);
    public Train getTrainById(Train train);
    public int insertTrain(Train train);
    public int updateTrain(Train train);
    public int deleteTrain(Train train);
}
