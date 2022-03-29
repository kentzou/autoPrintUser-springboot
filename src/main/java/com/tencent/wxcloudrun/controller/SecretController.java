package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.SecretRequest;
import com.tencent.wxcloudrun.model.Counter;
import com.tencent.wxcloudrun.model.SecretInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SecretController {
//    final Logger logger;
    /**
     * 获取当前计数
     * @return API response json
     */
    @GetMapping(value = "/api/info")
    ApiResponse get() {
        SecretInfo secret = new SecretInfo();
        String number = secret.getNumber();


        return ApiResponse.ok(number);
    }


    /**
     * 获取小程序信息
     * @param request {@link SecretRequest}
     * @return API response json
     */
    @PostMapping(value = "/api/info")
    ApiResponse create(@RequestBody SecretRequest request) {

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
