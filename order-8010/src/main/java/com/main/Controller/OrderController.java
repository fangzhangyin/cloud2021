package com.main.Controller;

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

    public static final String url = "http://PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/user/create")
    public CommonResult<User> create(User user) {
        return restTemplate.postForObject(url + "/user/create", user, CommonResult.class);
    }

    @GetMapping("/consumer/user/findone/{id}")
    public CommonResult<User> findone(@PathVariable("id") int id) {
        return restTemplate.getForObject(url + "/user/findone/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/user/get/{id}")
    public CommonResult<User> getone(@PathVariable("id") int id){
        ResponseEntity<CommonResult> entity=restTemplate.getForEntity(url+"/user/findone/"+id,CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            log.info(entity.toString());
            return entity.getBody();
        }else{
            return new CommonResult<User>(444,"操作失败");
        }
    }
}
