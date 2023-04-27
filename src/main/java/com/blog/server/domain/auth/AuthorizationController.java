package com.blog.server.domain.auth;

import com.blog.common.resopnse.ResponseResult;
import com.blog.server.domain.auth.config.AuthProperties;
import com.blog.server.domain.auth.dto.LoginDTO;
import com.blog.server.domain.auth.util.TokenStore;
import com.blog.server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthorizationController {

    private final AuthProperties authProperties;

    private final UserService userService;

    private final TokenStore tokenStore;

    @PostMapping("/login")
    public ResponseResult<String> login(LoginDTO dto) {
        return ResponseResult.success(userService.login(dto));
    }

    @GetMapping("/check")
    public Boolean checkToken(@RequestHeader("Authorization") String token) {
        tokenStore.verifyToken(token);
        return true;
    }

}