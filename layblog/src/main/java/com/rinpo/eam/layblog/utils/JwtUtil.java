package com.rinpo.eam.layblog.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.Base64Codec;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

/**
 * Token工具类
 * 
 */
public class JwtUtil {

	private static String tokenKey = "e-t-p";
	
	/**
	 * 由字符串生成加密key
	 * 
	 * @return
	 */
	private static Key generalKey(String key) {
		byte[] encodedKey = Base64Codec.BASE64.encode(key.getBytes())
				.getBytes();
		return new SecretKeySpec(encodedKey, "AES");
	}

	/**
	 * 创建token
	 * 
	 * @param userId
	 * @param key 可以为null
	 * @return
	 * @throws Exception
	 */
	public static String createToken(String userId, String key,
			Date expireDate) {
		
		if(key==null) {
			key = tokenKey;
		}
		String token = Jwts.builder().setSubject(userId)
				.signWith(SignatureAlgorithm.HS256, generalKey(key))
				.setIssuedAt(new Date()).setExpiration(expireDate).compact();
		return token;
	}

	/**
	 * 解析token
	 * 
	 * @param token
	 * @param key 可以为null
	 * @return
	 * @throws Exception
	 */
	public static Claims parseToken(String token, String key)
			throws Exception {
		if (token == null) {
			throw new NullPointerException("token不能为null");
		}
		if(key==null) {
			key = tokenKey;
		}
		return Jwts.parser().setSigningKey(generalKey(key))
				.parseClaimsJws(token).getBody();
	}

}
