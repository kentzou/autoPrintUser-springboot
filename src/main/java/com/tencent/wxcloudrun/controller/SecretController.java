package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.CounterRequest;
import com.tencent.wxcloudrun.model.Counter;
import com.tencent.wxcloudrun.model.SecretInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Controller
public class SecretController {
//    final Logger logger;


    /**
     * 获取小程序信息
     * @param request {@link CounterRequest}
     * @return API response json
     */
    @PostMapping(value = "/api/info")
    ApiResponse create(@RequestBody CounterRequest request) {
        SecretInfo secret = new SecretInfo();
        String number = secret.getNumber();
        String sec = secret.getSec();
        String change_chlothes_key = secret.getChange_chlothes_key();
        String make_identify_key = secret.getMake_identify_key();
        if (request.getAction().equals("number")) {
            return ApiResponse.ok(number);
        } else if (request.getAction().equals("sec")) {
            return ApiResponse.ok(sec);
        }  else if (request.getAction().equals("change_chlothes_key")) {
            return ApiResponse.ok(change_chlothes_key);
        } else if (request.getAction().equals("make_identify_key")) {
            return ApiResponse.ok(make_identify_key);
        }else {
            return ApiResponse.error("参数action错误");
        }
    }
}
