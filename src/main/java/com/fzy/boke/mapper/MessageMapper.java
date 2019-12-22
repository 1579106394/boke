package com.fzy.boke.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.fzy.boke.pojo.Message;
import com.fzy.boke.utils.Page;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 方紫英
 * @since 2019-12-14
 */
public interface MessageMapper extends BaseMapper<Message> {

    List<Message> findByPage(Page<Message> page);

    int findCount(Page<Message> page);
}
