package com.fzy.boke.service;

import com.baomidou.mybatisplus.service.IService;
import com.fzy.boke.pojo.Article;
import com.fzy.boke.utils.Page;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 方紫英
 * @since 2019-12-14
 */
public interface ArticleService extends IService<Article> {

    /**
     * 翻页查询
     * @param page
     * @return
     */
    Page<Article> selectByPage(Page<Article> page);
}
