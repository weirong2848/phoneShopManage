package com.mapper;

import com.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUserMapper {

    List<User> slectUser();

    User selectUserByUsername(String username);

    void addUser(User user);

    void updateUser(User user);

    User selectUserByEmail(String email);

}
