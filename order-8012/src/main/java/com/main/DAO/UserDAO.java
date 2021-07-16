package com.main.DAO;

import com.main.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDAO {
    public int create(User user);

    public User Byid(@Param("id") int id);

}
