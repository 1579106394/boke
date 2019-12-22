package com.fzy.boke.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author:
 * @Date: 2019/12/15 22:27
 * @Version 1.0
 */
@Controller
public class UploadController {

    /**
     * 上传图片，返回图片url
     *
     * @return
     */
    @RequestMapping("/uploadImg.action")
    @ResponseBody
    public Map<String, Object> uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/");
        System.out.println(realPath);
        // 重新随机生成文件名，防止文件名重复
        String name = UUID.randomUUID().toString().replaceAll("-", "");
        // 获取文件后缀
        String ext = FilenameUtils.getExtension(file.getOriginalFilename());
        // 拼接文件名
        String filename = name + "." + ext;
        // 文件上传路径
        String path = realPath + "/userImg/" + filename;
        // 上传文件
        file.transferTo(new File(path));
        // 文件在服务器上的路径
        String imagePath = "/userImg/" + filename;
        // 将路径返回到页面
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("url", imagePath);
        return dataMap;
    }

}
