package com.lowell.mdp.receiver.facade.Util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by Lowell on 2017/7/11.
 *
 *     启动类一定不能扫描到MapperInterface文件，所以放置在util目录下
 */

public interface MapperInterface<T> extends Mapper<T>, MySqlMapper<T> {

}
