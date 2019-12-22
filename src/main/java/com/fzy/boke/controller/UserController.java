package com.fzy.boke.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.fzy.boke.pojo.User;
import com.fzy.boke.service.UserService;
import com.fzy.boke.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册
     *
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/register.html")
    public String register(Model model, User user) {
        // 先查数据库，用户存在就不给注册
        User oldUser = userService.selectOne(new EntityWrapper<User>().eq("username", user.getUsername()));
        if (oldUser != null) {
            model.addAttribute("error", "用户已存在！");
            return "register";
        }

        user.setUserId(UUID.randomUUID().toString());
        userService.insert(user);

        return "login";
    }

    /**
     * 登录
     *
     * @param model
     * @param user
     * @param session
     * @return
     */
    @RequestMapping("/login.html")
    public String login(Model model, User user, HttpSession session) {
        // 先查数据库，用户不存在就不给登录
        User oldUser = userService.selectOne(new EntityWrapper<User>().eq("username", user.getUsername()));
        if (oldUser == null) {
            model.addAttribute("error", "用户不存在！");
            return "login";
        }
        session.setAttribute("user", oldUser);
        if (oldUser.getUserRole() == 2) {
            // 管理员
            return "redirect:/index/back.html";
        } else {
            // 普通用户
            return "redirect:/index/front.html";
        }
    }

    /**
     * 退出登录
     *
     * @param model
     * @param user
     * @param session
     * @return
     */
    @RequestMapping("/logOut.html")
    public String logOut(Model model, User user, HttpSession session) {
        session.removeAttribute("user");
        return "login";
    }

    /**
     * 后台分页
     *
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("/page.html")
    public String page(Page<User> page, Model model) {
        page = userService.selectByPage(page);
        model.addAttribute("page", page);
        return "userList";
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete.html")
    public String delete(String id) {
        userService.deleteById(id);
        return "redirect:/user/page.html";
    }

    /**
     * 拉黑
     *
     * @param id
     * @return
     */
    @RequestMapping("/black.html")
    public String black(String id) {
        User user = userService.selectById(id);
        user.setUserActive(0);
        userService.updateById(user);
        return "redirect:/user/page.html";
    }

    /**
     * 取消拉黑
     *
     * @param id
     * @return
     */
    @RequestMapping("/cancelBlack.html")
    public String cancelBlack(String id) {
        User user = userService.selectById(id);
        user.setUserActive(1);
        userService.updateById(user);
        return "redirect:/user/page.html";
    }

    /**
     * 修改个人信息
     *
     * @param user
     * @return
     */
    @RequestMapping("/updateDetail.html")
    public String updateDetail(User user, HttpSession session) {
        userService.updateById(user);
        User newUser = userService.selectById(user.getUserId());
        // 修改完个人信息，更新登录数据
        session.setAttribute("user", newUser);
        if (user.getUserRole() == 1) {
            return "redirect:/index/front.html";
        } else {
            return "redirect:/index/back.html";
        }
    }

}

