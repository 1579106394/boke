package com.fzy.boke.service;

import com.fzy.boke.pojo.Notice;
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
public interface NoticeService extends IService<Notice> {

    Page<Notice> selectByPage(Page<Notice> page);
}
