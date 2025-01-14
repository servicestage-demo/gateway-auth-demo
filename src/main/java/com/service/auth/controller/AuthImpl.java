package com.service.auth.controller;

import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthImpl.class);

    private static final String AUTH_TOKEN_HEADER_NAME = "x-auth-token";

    @RequestMapping(value = "/auth/**", method = {RequestMethod.GET, RequestMethod.HEAD, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.PATCH, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.TRACE})
    public ResponseEntity<Object> check(@RequestHeader Map<String, Object> headers, HttpServletResponse response) {
        LOGGER.info(AUTH_TOKEN_HEADER_NAME + "----" + headers.getOrDefault(AUTH_TOKEN_HEADER_NAME, ""));
        // 在此处实现具体的鉴权逻辑，对token的合法性进行校验
        if (!"ok".equalsIgnoreCase(headers.getOrDefault(AUTH_TOKEN_HEADER_NAME, "").toString())) {
            return new ResponseEntity<>(headers, HttpStatus.UNAUTHORIZED);
        }
        // 鉴权服务可以对返回的Response进行自定义设置,例如返回token中解析出来的userid
        headers.put("userid", "1234577654321");
        LOGGER.info("userid:1234577654321 login success");
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }
}
