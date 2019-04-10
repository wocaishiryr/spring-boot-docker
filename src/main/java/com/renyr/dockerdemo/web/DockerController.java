package com.renyr.dockerdemo.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "web接口")
@RestController
@RequestMapping("web")
public class DockerController {

    @ApiOperation(value = "index接口")
    @GetMapping("index")
    public String index() {
        return "hello spring boot + docker";
    }

    @ApiOperation("获取名称")
    @GetMapping("getName")
    public String getName(@ApiParam("名称")String name) {
        return name;
    }

    @ApiOperation("post请求接口")
    @PostMapping
    public boolean save(String user) {
        return null != user;
    }
}
