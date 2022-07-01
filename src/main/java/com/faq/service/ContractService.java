package com.faq.service;

import com.faq.entity.Contract;

import java.util.List;

public interface ContractService {

    public List<Contract> getContractList(Contract contract);
    public Contract getContractById(Contract contract);
    public Contract getContractByUserId(Contract contract);
    public int insertContract(Contract contract);
}
