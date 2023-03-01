package com.service;

import com.entity.CommonResult;
import com.entity.User;
import com.service.impl.UserFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(value = "userManage", fallback = UserFallbackService.class)
public interface IUserService {

    @GetMapping(value = "/user/slectUser")
    public CommonResult<List<User>> slectUser();

    @GetMapping(value = "/user/selectUserByUsername/{username}")
    public CommonResult<User> selectUserByUsername(@PathVariable("username")String userName);

    @GetMapping(value = "/user/selectUserByEmail/{email}")
    public CommonResult<User> selectUserByEmail(@PathVariable("email")String email);
}
