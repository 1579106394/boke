package com.fzy.boke.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.fzy.boke.pojo.Comment;
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
public interface CommentMapper extends BaseMapper<Comment> {

    List<Comment> findByPage(Page<Comment> page);

    int findCount(Page<Comment> page);

    List<Comment> getListByArticle(String id);
}
