package com.faq.service.impl;

import com.faq.entity.Contract;
import com.faq.mapper.ContractDao;
import com.faq.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractDao contractDao;

    @Override
    public List<Contract> getContractList(Contract contract){return contractDao.getContractList(contract);};
    @Override
    public Contract getContractById(Contract contract){return contractDao.getContractById(contract);};
    @Override
    public Contract getContractByUserId(Contract contract){return contractDao.getContractByUserId(contract);};
    @Override
    public int insertContract(Contract contract){return contractDao.insertContract(contract);};
}
