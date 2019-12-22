package com.fzy.boke.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.fzy.boke.pojo.User;
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
public interface UserMapper extends BaseMapper<User> {

    List<User> findByPage(Page<User> page);

    int findCount(Page<User> page);
}
