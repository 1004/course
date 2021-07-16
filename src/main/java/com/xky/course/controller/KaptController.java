package com.xky.course.controller;

import com.google.code.kaptcha.Producer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/7/16 11:33 上午
 */
@RestController
@RequestMapping("/kapt")
public class KaptController {

    //注入kapt生成器，注意id和名字对应，优先拿名字匹配到容器的id
    @Resource
    private Producer kaptchaProducer;

    @GetMapping("/verify")
    public void createVerifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //过期时间，立刻过期
        response.setDateHeader("Expires", 0);
        //设置不缓存响应
        response.setHeader("Cache-Control", "no-store,no-cache,must-revalidate");
        response.setHeader("Pragma", "no-cache");

        response.setContentType("image/png");
        //生成验证码字符文本
        String verifyCode = kaptchaProducer.createText();
        request.getSession().setAttribute("kaptchaVerifyCode", verifyCode);
        System.out.println(request.getSession().getAttribute("kaptchaVerifyCode"));
        BufferedImage image = kaptchaProducer.createImage(verifyCode);
        //输出图片到浏览器
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "png", out);
        //立刻输出
        out.flush();
        out.close();
    }
}
