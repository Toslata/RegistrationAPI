package com.registrationapi.config.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Key;
import java.util.Collections;
import java.util.Date;

public class TokenAuthenticationService
{
    static final long EXPIRATION_TIME = 5*60000; // 5 mins
    static final String HEADER_STRING = "Authorization";
    static final String TOKEN_PREFIX = "Bearer";
    static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    static void addAuthentication(HttpServletResponse resposne, String username)
    {
        String jwt = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY)
                .compact();

        resposne.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + jwt);

    }

    static Authentication getAuthentication(HttpServletRequest request)
    {
        String token = request.getHeader(HEADER_STRING);
        if(token == null)
        {
            return null;
        }

        String username = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                .getBody()
                .getSubject();

        return username != null ? new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList()): null;

    }
}
