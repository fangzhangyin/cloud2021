package com.main.Service;

import com.main.Entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    public int create(User user);

    public User Byid(@Param("id") int id);
}
