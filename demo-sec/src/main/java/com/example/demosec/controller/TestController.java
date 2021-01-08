package com.example.demosec.controller;

import com.example.democommon.entity.ResultData;
import com.example.demosec.entity.User;
import com.example.demosec.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "test", tags = "测试controller")
// 开启配置文件动态刷新
//@RefreshScope
@RequestMapping("test")
@RestController
public class TestController {

    @Autowired
    private UserService userService;
//    @Value("${testaa}")
//    private String cc;

    @ApiOperation(value = "testaa", notes = "测试")
    @GetMapping("aa")
    public ResultData testaa() {
        User user = userService.getUserByName("zhangsan");
        return ResultData.ok("成功", user);
    }

}
