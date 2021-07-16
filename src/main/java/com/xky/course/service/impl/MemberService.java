package com.xky.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xky.course.entry.Member;
import com.xky.course.entry.ResponseEntry;
import com.xky.course.mapper.MemberMapper;
import com.xky.course.service.IMemberService;
import com.xky.course.utils.Md5Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/7/16 3:12 下午
 */
@Service
@Transactional //开启事务
public class MemberService implements IMemberService {

    //ioc 容器中 取出，注入
    @Resource
    private MemberMapper memberMapper;

    /**
     *
     * 注册
     * 用户名不能重名
     * 密码必须经过加密
     * @param userName
     * @param pwd
     * @param nikeName
     * @return
     */
    public ResponseEntry<Object> register(String userName, String pwd, String nikeName) {
        if (userName == null || pwd == null || nikeName == null) {
            return new ResponseEntry(1000, "入参不全");
        }
        //①用户名不能重名
        QueryWrapper<Member> queryWrapper = new QueryWrapper<Member>();
        queryWrapper.eq("username", userName);
        List<Member> oldMembers = memberMapper.selectList(queryWrapper);
        if (oldMembers != null && oldMembers.size() > 0) {
            return new ResponseEntry<Object>(1001, "用户名重名");
        }
        //密码加密存储
        Member member = new Member();
        member.setUsername(userName);
        member.setNickname(nikeName);
        int salt = new Random().nextInt(1000) + 1000;
        member.setSalt(salt);
        member.setPassword(Md5Utils.md5(pwd,salt));
        member.setCreateTime(new Date());
        memberMapper.insert(member);
        return new ResponseEntry<Object>(0,"success");
    }
}
