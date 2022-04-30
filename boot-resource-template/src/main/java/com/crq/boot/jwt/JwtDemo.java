package com.crq.boot.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-21 20:19
 **/
public class JwtDemo {
    /**
     * 私钥 生成签名要用
     */
    private final static String SECRET = "123456789";

    public static String createJwtToken() {
        Map<String,Object> header = new HashMap<>(4);
        header.put("alg","HS256");
        header.put("type","JWT");

        //payload
        Map<String,Object> claims = new HashMap<>(8);
        //标准中注册的声明
        claims.put("iss","crq");
        claims.put("id","123456");
        claims.put("userName","admin");

        //生成JWT
        return Jwts.builder()
                .setHeader(header)
                .setClaims(claims)
                //设置jti : JWT的统一表示
                .setId(UUID.randomUUID().toString())
                //签发时间
                .setIssuedAt(new Date())
                //设置过期时间一小时
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .setSubject("Tom")
                //通过签名算法和密钥生成签名
                .signWith(SignatureAlgorithm.HS256,SECRET)
                .compact();
    }

    public static Claims getClaimsFromJson(String jwt) {
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(jwt).getBody();
    }

    public static void main(String[] args) {
        String jwtToken = createJwtToken();
        System.out.println("JWT Token:" + jwtToken);
        System.out.println("++++++++++++++++++++++");

        Claims claims = getClaimsFromJson(jwtToken);
        System.out.println("claims:" + claims);
    }

}
