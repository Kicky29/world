package com.tcsoft.world.service;

import com.tcsoft.world.mapper.UserMapper;
import com.tcsoft.world.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public int add(User user){
        return userMapper.add(user);
    }

    public void delete(int id){
        userMapper.delete(id);
    }

    public User get(int id){
        return userMapper.get(id);
    }

    public int update(User user){
        return userMapper.update(user);
    }

    public List<User> list(){
        return userMapper.list();
    }
}
