package com.lowell.mdp.receiver.facade.mapper;

import com.lowell.mdp.receiver.facade.Util.MapperInterface;
import com.lowell.mdp.receiver.facade.model.InnerMessages;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Lowell on 2017/7/10.
 */

@Mapper
public interface InnerMessageMapper extends MapperInterface<InnerMessages> {
    //其他必须手写的接口--多表关联操作
}
