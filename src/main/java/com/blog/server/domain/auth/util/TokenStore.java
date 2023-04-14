package com.blog.server.domain.auth.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.blog.common.entity.User;
import com.blog.server.domain.auth.config.AuthProperties;
import com.blog.server.domain.auth.constance.TokenConstance;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Date;
import java.util.Map;

@Component
public class TokenStore {

    private final AuthProperties authProperties;

    public TokenStore(AuthProperties authProperties) {
        this.authProperties = authProperties;
    }

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
            throw new IllegalArgumentException("生成token失败");
        }
    }


    public Map<String, Claim> checkToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(authProperties.getSecret()); //use more secure key
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(authProperties.getIssuer())
                .build(); //Reusable verifier instance
        DecodedJWT jwt = verifier.verify(token.replace("Bearer ", ""));
        return jwt.getClaims();
    }
}
