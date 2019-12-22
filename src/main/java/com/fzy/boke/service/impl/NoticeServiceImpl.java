package com.fzy.boke.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.fzy.boke.mapper.NoticeMapper;
import com.fzy.boke.mapper.NoticeMapper;
import com.fzy.boke.pojo.Notice;
import com.fzy.boke.pojo.Notice;
import com.fzy.boke.service.NoticeService;
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
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public Page<Notice> selectByPage(Page<Notice> page) {
        page.setIndex((page.getCurrentPage() - 1) * page.getCurrentCount());
        List<Notice> list = noticeMapper.findByPage(page);
        int count = noticeMapper.findCount(page);
        page.setList(list);
        page.setTotalCount(count);
        page.setTotalPage((int) Math.ceil(count * 1.0 / page.getCurrentCount()));
        return page;
    }
}
