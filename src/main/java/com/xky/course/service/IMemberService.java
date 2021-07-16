package com.xky.course.service;


import com.xky.course.entry.Member;
import com.xky.course.entry.ResponseEntry;

public interface IMemberService {
    public ResponseEntry<Object> register(String userName, String pwd, String nikeName);

    public ResponseEntry<Member> login(String userName,String pwd);
}
