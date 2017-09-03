package com.lowell.mdp.receiver.facade.handler;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.lowell.mdp.receiver.facade.model.InnerMessages;
import com.lowell.mdp.receiver.facade.model.MsgTemplate;
import com.lowell.mdp.receiver.facade.service.InnerMessageService;
import com.lowell.mdp.receiver.facade.service.MsgTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * Created by HP on 2017/7/7.
 *
 * 站内信接收器
 *
 */
@Service
public class InnerMsgHandler {


    private static final Logger log = LoggerFactory.getLogger(InnerMsgHandler.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    private MsgTemplateService msgTemplateService;

    @Autowired
    private InnerMessageService innerMessageService;

    /**
     * 配置消息队列名称
     *
     * @param message
     */
    @RabbitListener(queues = "spring-boot-simple")
    public void receiveMessage(String message) {
        log.info("Received message[content:" + message + "] from MQ");


        Map<String, Object> paraMap = null;
        try {
            paraMap = (Map) JSONObject.parse(message);
        }catch (Exception e){
            log.info("parse message from json to map error[content:"+message+"] from MQ");
        }

        if(null==paraMap || null==paraMap.get("template_code") || StringUtils.isEmpty(paraMap.get("template_code").toString())){
            log.info("parse message from json to map error[content:"+message+"] from MQ");
            return;
        }


        MsgTemplate msgTemplate = msgTemplateService.getMsgTemplateByCode(paraMap.get("template_code").toString());
        if(null == msgTemplate){
            log.info("can't get the message template by template code["+paraMap.get("template_code").toString()+"]");
            return;
        }

        /**
         * 内容替换
         */
        String content = msgTemplate.getContent();
        for(String key : paraMap.keySet()){
            content = content.replace("$"+key,paraMap.get(key).toString());
        }

        InnerMessages innerMessages = new InnerMessages();
        innerMessages.setTemplateCode(paraMap.get("template_code").toString());
        innerMessages.setReferenceType(paraMap.get("reference_type").toString());
        innerMessages.setReferenceId(paraMap.get("reference_id").toString());
        innerMessages.setContent(content);
        innerMessages.setStatus(1);
        innerMessages.setVersionNum(1);
        innerMessages.setCreatedBy("mdp-deliverer");
        innerMessages.setUpdatedBy("mdp-deliverer");
        Date time = new Date();
        innerMessages.setCreatedAt(time);
        //innerMessages.setUpdatedAt(time);


        innerMessageService.saveInnerMessage(innerMessages);

    }
}
