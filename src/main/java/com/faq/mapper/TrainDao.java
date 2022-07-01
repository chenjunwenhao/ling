package com.faq.mapper;

import com.faq.entity.Train;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TrainDao {

    public List<Train> getTrain(Train train);
    public Train getTrainById(Train train);
    public int insertTrain(Train train);
    public int updateTrain(Train train);
    public int deleteTrain(Train train);
}
