package com.fzy.boke.service;

import com.fzy.boke.pojo.Comment;
import com.baomidou.mybatisplus.service.IService;
import com.fzy.boke.utils.Page;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 方紫英
 * @since 2019-12-14
 */
public interface CommentService extends IService<Comment> {

    Page<Comment> selectByPage(Page<Comment> page);

    /**
     * 根据文章id查询
     * @param id
     * @return
     */
    List<Comment> getListByArticle(String id);
}
