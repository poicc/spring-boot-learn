package com.crq.boot.controller;

import com.crq.boot.entity.dto.UserDto;
import com.crq.boot.service.impl.UserServiceImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: crq
 * @create: 2022-04-25 13:51
 **/
@RestController
@RequestMapping(value="/user")
public class UserController {
    @Resource
    private UserServiceImpl userService;

    @PostMapping("/reg")
    public String insertUser(@Valid @RequestBody UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errorMsg = bindingResult.getAllErrors().stream().map(s -> s.getDefaultMessage())
                    .collect(Collectors.toList());
            return errorMsg.get(0);
        }
        return userService.insertUser(userDto.getUsername(),userDto.getPassword());
    }

    @GetMapping("/active/{id}")
    public String insertUser(@PathVariable("id") int id) {
        userService.activeUser(id);
        return "激活成功";
    }
}
