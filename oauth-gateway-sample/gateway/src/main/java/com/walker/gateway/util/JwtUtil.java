package com.walker.gateway.util;

import com.walker.gateway.exception.PermissionException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author walker
 * @date 2019/1/3
 */
public class JwtUtil {

    public static final String SECRET = "1weunakleio123499jdnlsxx";
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String HEADER_AUTH = "Authorization";

    public static String generateToken(String user) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", new Random().nextInt());
        map.put("user", user);
        String jwt = Jwts.builder()
                .setSubject("user info").setClaims(map)
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
        return TOKEN_PREFIX + " " + jwt;
    }

    public static Map<String, String> validateToken(String token) {
        if (token != null) {
            Map<String, String> params = new HashMap<>();
            Map<String, Object> body = Jwts.parser().setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
            String id = String.valueOf(body.get("id"));
            String user = String.valueOf(body.get("user"));
            params.put("id", id);
            params.put("user", user);
            if (StringUtils.isEmpty(user)) {
                throw new PermissionException("user is error, please check");
            }
            return params;
        } else {
            throw new PermissionException("token is error, please check");
        }
    }
}
