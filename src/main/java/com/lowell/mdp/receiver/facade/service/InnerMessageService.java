package com.lowell.mdp.receiver.facade.service;

import com.lowell.mdp.receiver.facade.mapper.InnerMessageMapper;
import com.lowell.mdp.receiver.facade.model.InnerMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Lowell on 2017/7/10.
 */

@Service
public class InnerMessageService {

    private static final Logger log = LoggerFactory.getLogger(InnerMessageService.class);

    @Autowired
    private InnerMessageMapper innerMessageMapper;


    public Long saveInnerMessage(InnerMessages innerMessages){
        return new Long(innerMessageMapper.insert(innerMessages));
    }
}
