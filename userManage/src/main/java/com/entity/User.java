package com.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private String username;//用户名
    private String password;//密码
    private Integer gold;//金币
    private Integer isadmin;//是否管理员
    private String email;//邮箱

}
