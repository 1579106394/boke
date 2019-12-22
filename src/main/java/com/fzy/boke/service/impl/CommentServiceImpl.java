package com.fzy.boke.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.fzy.boke.mapper.CommentMapper;
import com.fzy.boke.pojo.Comment;
import com.fzy.boke.service.CommentService;
import com.fzy.boke.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 方紫英
 * @since 2019-12-14
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Page<Comment> selectByPage(Page<Comment> page) {
        page.setIndex((page.getCurrentPage() - 1) * page.getCurrentCount());
        List<Comment> list = commentMapper.findByPage(page);
        int count = commentMapper.findCount(page);
        page.setList(list);
        page.setTotalCount(count);
        page.setTotalPage((int) Math.ceil(count * 1.0 / page.getCurrentCount()));
        return page;
    }

    @Override
    public List<Comment> getListByArticle(String id) {
        return commentMapper.getListByArticle(id);
    }
}
