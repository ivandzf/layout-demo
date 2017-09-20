package com.greenlabs.layoutdemo.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by Ivan-TI on 9/20/2017
 **/
@Service
public class BaseService {

    @Autowired
    protected TransactionTemplate transactionTemplate;

}
