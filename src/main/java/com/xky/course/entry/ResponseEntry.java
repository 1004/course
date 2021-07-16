package com.xky.course.entry;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/7/16 2:53 下午
 */
public class ResponseEntry<T> {
    public ResponseEntry(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseEntry(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
