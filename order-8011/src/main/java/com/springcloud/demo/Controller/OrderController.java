package com.springcloud.demo.Controller;

import com.main.Entity.CommonResult;
import com.main.Entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    //    public static final String url = "http://localhost:8001";

    public static final String url = "http://payment-service";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/zk/user/create")
    public CommonResult<User> create(User user) {
        return restTemplate.postForObject(url + "/user/create", user, CommonResult.class);
    }

    @GetMapping("/consumer/zk/user/findone/{id}")
    public CommonResult<User> findone(@PathVariable("id") int id) {
        return restTemplate.getForObject(url + "/user/findone/" + id, CommonResult.class);
    }

}
