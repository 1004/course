package com.xky.course.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author xiekongying
 * @version 1.0
 * @date 2021/7/16 3:20 下午
 */
public class Md5Utils {
    public static String md5(String source, int salt) {
        char[] chars = source.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] + salt);
        }
        String target = new String(chars);
        return DigestUtils.md5Hex(target);
    }
}
