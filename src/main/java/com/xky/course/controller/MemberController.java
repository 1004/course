package com.xky.course.controller;

import com.xky.course.entry.Member;
import com.xky.course.entry.ResponseEntry;
import com.xky.course.service.IMemberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/7/16 3:25 下午
 */
@RestController
@RequestMapping("/member")
public class MemberController {
    @Resource
    private IMemberService iMemberService;

    @PostMapping("/create")
    public ResponseEntry<Object> create(@RequestParam(value = "userName", required = false) String userName,
                                        @RequestParam(value = "pwd", required = false) String pwd,
                                        @RequestParam(value = "nikeName", required = false) String nikeName,
                                        @RequestParam(value = "verCode", required = false) String verCode,
                                        HttpServletRequest request) {
        String serverVerCode = (String) request.getSession().getAttribute("kaptchaVerifyCode");
        if (verCode == null || !verCode.equalsIgnoreCase(serverVerCode)) {
            return new ResponseEntry<Object>(1004, "验证码不正确");
        }
        return iMemberService.register(userName, pwd, nikeName);
    }

    /**
     * 登录
     * 登录成功后，往往会获取token
     * @param userName
     * @param pwd
     * @param verCode
     * @param request
     * @return
     */
    @PostMapping("/login")
    public ResponseEntry<Member> login(@RequestParam(value = "userName", required = false) String userName,
                                       @RequestParam(value = "pwd", required = false) String pwd,
                                       @RequestParam(value = "verCode", required = false) String verCode,
                                       HttpServletRequest request) {
        String serverVerCode = (String) request.getSession().getAttribute("kaptchaVerifyCode");
        if (verCode == null || !verCode.equalsIgnoreCase(serverVerCode)) {
            return new ResponseEntry<Member>(1004, "验证码不正确");
        }
        return iMemberService.login(userName, pwd);
    }
}
