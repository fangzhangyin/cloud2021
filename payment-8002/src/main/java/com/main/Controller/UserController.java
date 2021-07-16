package com.main.Controller;

import com.main.Entity.CommonResult;
import com.main.Entity.User;
import com.main.Service.imp.UserServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class UserController {

    @Resource
    private UserServiceImp userServiceImp;

    @Value("${server.port}")
    private String serverport;

    @PostMapping("/user/create")
    public CommonResult create(@RequestBody User user) {
        int result = userServiceImp.create(user);
        CommonResult commonResult = new CommonResult();
        log.info("插入数据库" + result);
        if (result > 0) {
            commonResult.setCode(200);
            commonResult.setData(result);
            commonResult.setMessage("插入数据成功==" + serverport);
        } else {
            commonResult.setCode(444);
            commonResult.setData(null);
            commonResult.setMessage("插入数据失败==" + serverport);
        }
        return commonResult;
    }

    @GetMapping("/user/findone/{id}")
    public CommonResult findone(@PathVariable("id") int id) {
        User user = userServiceImp.Byid(id);
        CommonResult commonResult = new CommonResult();
        if (user != null) {
            commonResult.setCode(200);
            commonResult.setData(user);
            commonResult.setMessage("查找成功==" + serverport);
        } else {
            commonResult.setCode(444);
            commonResult.setData(null);
            commonResult.setMessage("查找失败==" + serverport);
        }
        return commonResult;
    }

}
