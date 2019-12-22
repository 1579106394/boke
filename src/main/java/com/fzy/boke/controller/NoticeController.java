package com.fzy.boke.controller;

import com.fzy.boke.pojo.Notice;
import com.fzy.boke.service.NoticeService;
import com.fzy.boke.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 方紫英
 * @since 2019-12-14
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    /**
     * 查询公告列表带搜索和分页
     *
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("/page.html")
    public String page(Page<Notice> page, Model model) {
        page = noticeService.selectByPage(page);
        model.addAttribute("page", page);
        return "noticeList";
    }

    /**
     * 保存公告
     *
     * @param notice
     * @return
     */
    @RequestMapping("/add.html")
    public String add(Notice notice) {
        notice.setNoticeId(UUID.randomUUID().toString());
        notice.setNoticeTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        notice.setNoticeRead(0);
        noticeService.insert(notice);
        return "redirect:/notice/page.html";
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete.html")
    public String delete(String id) {
        noticeService.deleteById(id);
        return "redirect:/notice/page.html";
    }

    /**
     * 查询回显到修改
     */
    @RequestMapping("/toEdit.html")
    public String toEdit(String id, Model model) {
        Notice notice = noticeService.selectById(id);
        model.addAttribute("notice", notice);
        return "noticeEdit";
    }

    /**
     * 修改公告
     */
    @RequestMapping("/edit.html")
    public String edit(Notice notice) {
        noticeService.updateById(notice);
        return "redirect:/notice/page.html";
    }

    /**
     * 根据id查询
     * 返回json
     *
     * @param message
     * @return
     */
    @RequestMapping("/getById.action")
    @ResponseBody
    public Notice getById(@RequestBody Notice message) {
        Notice notice = noticeService.selectById(message.getNoticeId());
        notice.setNoticeRead(notice.getNoticeRead() + 1);
        noticeService.updateById(notice);
        return notice;
    }
}

