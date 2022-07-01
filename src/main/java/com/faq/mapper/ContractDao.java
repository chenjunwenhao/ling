package com.faq.mapper;

import com.faq.entity.Contract;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContractDao  {
    public List<Contract> getContractList(Contract contract);
    public Contract getContractById(Contract contract);
    public Contract getContractByUserId(Contract contract);
    public int insertContract(Contract contract);


}
