package com.service.impl;

import com.entity.CommonResult;
import com.entity.User;
import com.service.IUserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserFallbackService implements IUserService {

    public CommonResult<List<User>> slectUser() {
        CommonResult<List<User>> commonResult = new CommonResult<>("500","查询失败",null);
        return commonResult;
    }

    @Override
    public CommonResult<User> selectUserByUsername(String username) {
        CommonResult<User> commonResult = new CommonResult<>("500","查询失败",null);
        return commonResult;
    }

    @Override
    public CommonResult<User> selectUserByEmail(String email) {
        CommonResult<User> commonResult = new CommonResult<>("500","查询失败",null);
        return commonResult;
    }
}
