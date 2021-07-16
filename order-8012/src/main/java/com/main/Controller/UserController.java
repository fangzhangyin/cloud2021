package com.main.Controller;

import com.main.Entity.CommonResult;
import com.main.Entity.User;
import com.main.Service.imp.UserServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@Slf4j
public class UserController {

    public static final String ConculURL = "http://consul-payment-service";

    @Resource
    private UserServiceImp userServiceImp;

    @Value("${server.port}")
    private String serverport;

    @RequestMapping("/payment/consul")
    public String paymentZK() {
        return "consul端口" + serverport + "\t" + UUID.randomUUID().toString();
    }

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/consul/user/create")
    public CommonResult<User> create(User user) {
        return restTemplate.postForObject(ConculURL + "/user/create", user, CommonResult.class);
    }

    @GetMapping("/consumer/consul/user/findone/{id}")
    public CommonResult<User> findone(@PathVariable("id") int id) {
        return restTemplate.getForObject(ConculURL + "/user/findone/" + id, CommonResult.class);
    }

}
