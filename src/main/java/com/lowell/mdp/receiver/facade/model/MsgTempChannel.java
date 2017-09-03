package com.lowell.mdp.receiver.facade.model;

import lombok.Data;

import java.sql.Date;

/**
 * Created by HP on 2017/7/10.
 */
@Data
public class MsgTempChannel {

    private long id;
    private String tempCode;
    private String channelCode;
    private int status;
    private int version;
    private String createdBy;
    private Date createdAt;
    private String updatedBy;
    private Date updatedAt;
}
