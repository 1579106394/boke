package com.fzy.boke.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.fzy.boke.pojo.Notice;
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
public interface NoticeMapper extends BaseMapper<Notice> {

    List<Notice> findByPage(Page<Notice> page);

    int findCount(Page<Notice> page);
}
