package com.controller;

import com.entity.CommonResult;
import com.entity.User;
import com.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userService")
    private IUserService userService;

    @RequestMapping("/selectUserByUsername/{username}")
    public CommonResult<User> selectUserByUsername(@PathVariable("username")String username){
        User user = userService.selectUserByUsername(username);
        CommonResult<User> commonResult = new CommonResult<>("0000","查询成功",user);
        return commonResult;
    }

    @RequestMapping("/selectUserByEmail/{email}")
    public CommonResult<User> selectUserByEmail(@PathVariable("email")String email){
        User user = userService.selectUserByEmail(email);
        CommonResult<User> commonResult = new CommonResult<>("0000","查询成功",user);
        return commonResult;
    }

    @GetMapping("/slectUser")
    public CommonResult<List<User>> slectUser(){
        List<User> userList = userService.slectUser();
        CommonResult<List<User>> commonResult = new CommonResult<>("0000","查询成功",userList);
        return commonResult;
    }

    @RequestMapping("/addUser")
    public void addUser(User user){
        userService.addUser(user);
    }

    @RequestMapping("/updateUser")
    public void updateUser(User user){
        userService.updateUser(user);
    }

}
