package com.lowell.mdp.receiver.facade.service;

import com.lowell.mdp.receiver.facade.mapper.MsgTemplateMapper;
import com.lowell.mdp.receiver.facade.model.MsgTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Lowell on 2017/7/10.
 */

@Service
public class MsgTemplateService {

    private static final Logger log = LoggerFactory.getLogger(MsgTemplateService.class);

    @Autowired
    private MsgTemplateMapper messageTemplateMapper;

    /**
     *
     * @param msgTempateCode
     * @return
     */
    public MsgTemplate getMsgTemplateByCode(String msgTempateCode){

        MsgTemplate temp = new MsgTemplate();
        temp.setCode(msgTempateCode);
        MsgTemplate result = messageTemplateMapper.selectOne(temp);
        return result;

    }
}
