package com.controller;

import com.entity.CommonResult;
import com.entity.User;
import com.service.IOrderservice;
import com.service.IUserService;
import com.util.Email;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/userManage")
public class UserManageController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Resource
    private IUserService userService;

    @Resource
    private IOrderservice orderService;

    public String verificationKey = "verificationKey:";

    public String userTokenKey = "userToken";

    @RequestMapping("/returnAll")
    public CommonResult<List<User>> returnAllUser(){
        CommonResult<List<User>> commonResult = new CommonResult<>("0000","成功");
        commonResult = userService.slectUser();
        return commonResult;
    }

    @RequestMapping("/sendCode")
    @ResponseBody
    @Transactional
    public String sendCode(String email){//生成验证码
        if(!"".equals(email)){
            ValueOperations<String,String> opsForValue = redisTemplate.opsForValue();
            String verificationCode = ""+(int)((Math.random()*9+1)*100000);
            String uuid = UUID.randomUUID().toString().replace("-", "");
            String sendverificationKey = verificationKey+":"+email+":"+uuid;//储存验证码的key
            opsForValue.set(sendverificationKey,verificationCode,60 * 6, TimeUnit.SECONDS);
            System.out.println(verificationCode);
//            Email mail = new Email();
//            mail.sendEmails(username,verificationCode);
            return sendverificationKey;
        }else{
            return null;
        }
    }

    @RequestMapping("/login")
    public CommonResult login(String email, String password, String verificationCode, String sendVerificationKey, HttpSession session){
        CommonResult loginResult = new CommonResult();
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(email,password));
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            String returnCode = redisTemplate.opsForValue().get(sendVerificationKey);
            System.out.println(returnCode);
            if(verificationCode!="" && sendVerificationKey !="" && verificationCode.equals(returnCode)){
                if(user.getIsadmin() == 1){
                    session.setAttribute("loginUser",user);
                    loginResult = new CommonResult("0000", "登入成功", user);
                    redisTemplate.delete(sendVerificationKey);//删除验证码
                    String userToken = userTokenKey+":"+user.getEmail()+":"+UUID.randomUUID().toString().replace("-", "");//用户同Tokend存储的key
                    Map<String,String> map = new HashMap<>();
                    map.put("username",user.getUsername());
                    map.put("email",user.getEmail());
                    redisTemplate.opsForHash().putAll(userToken,map);//存储用户信息
                    redisTemplate.opsForHash().getOperations().expire(userToken,60 * 30, TimeUnit.SECONDS);//设置过期时间
                }else{
                    loginResult = new CommonResult("03", "非管理员账户，不能登入系统", null);
                }
            }else{
                loginResult = new CommonResult("04", "验证码错误", null);
            }
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            loginResult = new CommonResult("01", "用户不存在", null);
        } catch (IncorrectCredentialsException e) {
            loginResult = new CommonResult("02", "密码错误", null);
        }
        return loginResult;

    }

    @RequestMapping("/returnLogin")
    public ModelAndView returnLogin(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping("/returnIndex")
    public ModelAndView returnIndex(){
        ModelAndView mv = new ModelAndView();
        CommonResult<List<Map<String,Object>>> commonResult1 = orderService.selectAllSell();
        CommonResult<List<Map<String,Object>>> sellNumResult = orderService.selectSellNumByCategory(1);
        List<Map<String,Object>> phoneList = sellNumResult.getData();
        List<Integer> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        Map<String, Integer> map1 = new HashMap();
        Map<String, Object> map = new HashMap();
        for(int i =0;i<phoneList.size();i++){
            map = phoneList.get(i);
            map1.put((String) map.get("model"),(Integer) map.get("num"));
//            list.add((Integer) map.get("num"));
//            list2.add((String) map.get("model"));
        }
        System.out.println(map1);
//        System.out.println(list);
//        System.out.println(list2);

        mv.addObject("commonResult1",commonResult1);
        mv.addObject("sellNumResult",sellNumResult);
        mv.addObject("list",list);
        mv.addObject("list2",list2);
        mv.addObject("map1",map1);

        mv.setViewName("index");
        return mv;
    }

}
