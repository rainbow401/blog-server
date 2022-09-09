package com.blog.server.domain.auth.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.blog.common.entity.User;
import com.blog.server.domain.auth.config.AuthProperties;
import com.blog.server.domain.auth.constance.TokenConstance;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@RequiredArgsConstructor
@Component
public class TokenStore {

    private final AuthProperties authProperties;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(authProperties.getSecret());
            Date date = new Date(new Date().getTime() + authProperties.getExp());
            return JWT.create()
                    .withIssuer(authProperties.getIssuer())
                    .withClaim(TokenConstance.USERNAME, user.getUsername())
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (JWTCreationException e){
            e.printStackTrace();
            return null;
        }
    }
}
