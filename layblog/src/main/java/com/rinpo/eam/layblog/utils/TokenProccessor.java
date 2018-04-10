package com.rinpo.eam.layblog.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;

import sun.misc.BASE64Encoder;

/**
 * 生成Token的工具类TokenProccessor
 * MD5是一种不可逆的摘要算法，生成二进制数据，用于产生fingerprint(指纹)，以防止被“篡改”
 * Base64是一种编码方式，主要用于将二进制数据转换为文本数据，方便使用HTTP协议等，是可逆的
 * （编码后的字符位数与编码前的字节位数有关，将三个字节变成四个字符，不能被3整除，则加上特殊符号，所以
 * 编码后的字符串最后经常会有等号，最多两个等号）
 * 可用于soapui里的报文头部加密
 * @author ZSQ
 *
 */
public class TokenProccessor {

    /**
     *单例设计模式（保证类的对象在内存中只有一个）
     *1、把类的构造函数私有
     *2、自己创建一个类的对象
     *3、对外提供一个公共的方法，返回类的对象
     */
    private TokenProccessor(){}
    
    private static final TokenProccessor instance = new TokenProccessor();
    
    /**
     * 返回类的对象
     * @return
     */
    public static TokenProccessor getInstance(){
        return instance;
    }
    
    /**
     * 生成Token
     * Token：Nv6RRuGEVvmGjB+jimI/gw==
     * @return
     */
    public String makeToken(){  //checkException
        //  7346734837483  834u938493493849384  43434384
        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
        //数据指纹   128位长   16个字节  md5
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] =  md.digest(token.getBytes());
            //base64编码--任意二进制编码明文字符   adfsdfsdfsf
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * 生成Token
     * 为什么用md5算法加密后又要利用base64算法进行编码：
     * 因为md5加密后得到的数据是128位的字节数组，将字节数组用base64算法加密后得到的是字符串，这样有利于在其在数据库中的存储
     * Token：Nv6RRuGEVvmGjB+jimI/gw==
     * @return
     */
    public String makeToken(String key){  //checkException
        //数据指纹   128位长   16个字节  md5
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] =  md.digest(key.getBytes());
            //base64编码--任意二进制编码明文字符   adfsdfsdfsf
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * 生成一个能用于url参数的md5 token
     * @param key
     * @return
     */
    public String makeTokenURLSafe(String key){  //checkException
        //数据指纹   128位长   16个字节  md5
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] =  md.digest(key.getBytes());
            //base64编码--任意二进制编码明文字符   adfsdfsdfsf
            BASE64Encoder encoder = new BASE64Encoder();
            String result=encoder.encode(md5);
            result=result.replaceAll("\\+", "-").replaceAll("/", "_").replaceAll("=", "");
            return result;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * 生成一个能用于url参数的md5 token
     * @param key
     * @return
     */
    public String makeTokenURLSafe(){  //checkException
        return makeTokenURLSafe(UUID.randomUUID().toString()+System.currentTimeMillis() + new Random().nextInt(999999999));
    }
    
    public static void main(String[] args){
    	System.out.println(TokenProccessor.getInstance().makeTokenURLSafe("99999976password2017-07-11T06:32:29.064Z"));;
    }
}
