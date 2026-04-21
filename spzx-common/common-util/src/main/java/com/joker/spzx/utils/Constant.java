package com.joker.spzx.utils;

import com.google.common.collect.Lists;

import java.util.List;

public class Constant {

    public static final List<String> whiteList= Lists.newArrayList(
            "/admin/system/index/login",
            "/admin/system/index/genVarifyCode",
            "/admin/system/fileUpload",
            "/js/**",
            "/css/**",
            "/img/**",
            "/fonts/**",
            "/index.html",
            "/favicon.ico",
            "/swagger-ui.html",
            "/webjars/**",
            "/swagger-resources/**",
            "/v3/**",
            "/webjars/**",
            "/api-docs/**",
            "/doc.html");
}
