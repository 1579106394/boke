package com.fzy.boke.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.fzy.boke.mapper.ArticleMapper;
import com.fzy.boke.pojo.Article;
import com.fzy.boke.service.ArticleService;
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
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Page<Article> selectByPage(Page<Article> page) {
        page.setIndex((page.getCurrentPage() - 1) * page.getCurrentCount());
        List<Article> list = articleMapper.findByPage(page);
        int count = articleMapper.findCount(page);
        page.setList(list);
        page.setTotalCount(count);
        page.setTotalPage((int) Math.ceil(count * 1.0 / page.getCurrentCount()));
        return page;
    }
}
