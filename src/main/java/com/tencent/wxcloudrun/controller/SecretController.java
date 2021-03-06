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

    /**
     * 获取小程序信息
     * @param request {@link SecretRequest}
     * @return API response json
     */
    @PostMapping(value = "/api/info")
    ApiResponse create(@RequestBody SecretRequest request) {

        SecretInfo info = new SecretInfo();

        if (request.getAction().equals("appid")) {
            return ApiResponse.ok(info.getAppid());
        } else if (request.getAction().equals("secret")) {
            return ApiResponse.ok(info.getSecret());
        }  else if (request.getAction().equals("change_chlothes_key")) {
            return ApiResponse.ok(info.getChange_chlothes_key());
        } else if (request.getAction().equals("make_identify_key")) {
            return ApiResponse.ok(info.getMake_identify_key());
        }else if (request.getAction().equals("baseURL")) {
            return ApiResponse.ok(info.getBaseURL());
        }else {
            return ApiResponse.error("参数action错误");
        }
    }
}
