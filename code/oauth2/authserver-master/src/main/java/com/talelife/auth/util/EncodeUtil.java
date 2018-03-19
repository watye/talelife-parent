package com.talelife.auth.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncodeUtil {
	public static String encoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        //确定计算方法
        MessageDigest md5=MessageDigest.getInstance("MD5");
        md5.update(str.getBytes());  
        // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符  
        // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值  
        return new BigInteger(1, md5.digest()).toString(16);  
    }

}
