package com.tcsoft.world.mapper;

import com.tcsoft.world.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public int add(User user);

    public void delete(int id);

    public User get(int id);

    public int update(User user);

    public List<User> list();
}
