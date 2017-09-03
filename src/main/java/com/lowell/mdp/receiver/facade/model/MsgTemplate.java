package com.lowell.mdp.receiver.facade.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * Created by Lowell on 2017/7/10.
 */
@Data
@Table(name = "t_msg_templates")
public class MsgTemplate {

    @Id
    private Long id;
    private String code;
    private String name;
    private String content;
    private Integer templateType;
    private String description;
    private Integer status;
    private Integer versionNum;
    private String createdBy;
    private Date createdAt;
    private String updatedBy;
    private Date updatedAt;

}
