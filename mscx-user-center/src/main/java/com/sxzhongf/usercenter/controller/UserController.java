package com.sxzhongf.usercenter.controller;

import com.sxzhongf.usercenter.domain.entity.user.User;
import com.sxzhongf.usercenter.service.user.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * UserController for TODO
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2019/7/11
 */
@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class UserController {

    //使用lombok的方式注入bean
    private final UserService userService;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        log.info("UserController#findById : {}", id);
        return userService.findById(id);
    }

    @GetMapping("/q")
    public User query(User user) {
        return user;
    }

    @PostMapping("/create")
    @ApiOperation(value = "创建用户---分布式测试")
    public User createUser(@RequestBody User user) {
        log.info("分布式事务测试---新增用户：{}",user);
        this.userService.create(user);
        return null;
    }
}
