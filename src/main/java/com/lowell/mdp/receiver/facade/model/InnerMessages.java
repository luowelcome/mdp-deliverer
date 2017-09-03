package com.lowell.mdp.receiver.facade.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by HP on 2017/7/10.
 */
@Data
@Table(name = "t_inner_messages")
public class InnerMessages {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;
    private String templateCode;
    private String referenceType;
    private String referenceId;
    private String content;
    private Integer status;
    private Integer versionNum;
    private String createdBy;
    private Date createdAt;
    private String updatedBy;
    private Date updatedAt;
}
