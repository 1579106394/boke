package com.fzy.boke.service;

import com.fzy.boke.pojo.Message;
import com.baomidou.mybatisplus.service.IService;
import com.fzy.boke.utils.Page;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 方紫英
 * @since 2019-12-14
 */
public interface MessageService extends IService<Message> {

    /**
     * 分页查询
     * @param page
     * @return
     */
    Page<Message> selectByPage(Page<Message> page);
}
