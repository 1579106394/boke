package com.fzy.boke.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.fzy.boke.mapper.UserMapper;
import com.fzy.boke.mapper.UserMapper;
import com.fzy.boke.pojo.User;
import com.fzy.boke.pojo.User;
import com.fzy.boke.service.UserService;
import com.fzy.boke.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 方紫英
 * @since 2019-12-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Page<User> selectByPage(Page<User> page) {
        page.setIndex((page.getCurrentPage() - 1) * page.getCurrentCount());
        List<User> list = userMapper.findByPage(page);
        int count = userMapper.findCount(page);
        page.setList(list);
        page.setTotalCount(count);
        page.setTotalPage((int) Math.ceil(count * 1.0 / page.getCurrentCount()));
        return page;
    }
}
