package com.bvtw.utils;

import org.springframework.stereotype.Component;

@Component
public class ApiCodes {
    // Nhóm thành công (0000-0099)
    public static final String SUCCESS = "0000";
    public static final String PARTIAL_SUCCESS = "0001";

    // Nhóm xác thực và phân quyền (1000-1999)
    public static final String AUTH_ERROR = "1000";
    public static final String UNAUTHORIZED = "1001";
    public static final String TOKEN_EXPIRED = "1002";

    // Nhóm lỗi đầu vào (2000-2999)
    public static final String INPUT_ERROR = "2000";
    public static final String INVALID_REQUEST = "2001";
    public static final String NOT_FOUND = "2101";

    // Nhóm lỗi hệ thống và máy chủ (5000-5999)
    public static final String SERVER_ERROR = "5000";
    public static final String INTERNAL_ERROR = "5001";
}
