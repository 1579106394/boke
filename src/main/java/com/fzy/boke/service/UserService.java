package com.fzy.boke.service;

import com.fzy.boke.pojo.User;
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
public interface UserService extends IService<User> {

    Page<User> selectByPage(Page<User> page);
}
