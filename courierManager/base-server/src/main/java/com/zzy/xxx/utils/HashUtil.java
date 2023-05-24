package com.zzy.xxx.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Created with IntelliJ IDEA.
 *
 * @description:
 * @author: zzy
 * @date: 2023/4/17
 */
public class HashUtil {

    /**
     * 将字符串使用自己加盐，迭代1200次
     *
     * @param word 待加密的字符串
     * @return 密文
     */
    public static String createMd5Hash(String word) {
        final Md5Hash md5Hash = new Md5Hash(word, word, 1200);
        return md5Hash.toHex();
    }
}
