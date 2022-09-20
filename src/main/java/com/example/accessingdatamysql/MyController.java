package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller //声明为Controller类
@RequestMapping(path = "/mysql")
public class MyController {
    @Autowired //这意味着要获得名为userRepository的bean,它是Spring自动生成的，我们将使用它来处理数据
    private UserRepository userRepository;
    @PostMapping(path = "/add")
    public @ResponseBody Iterable<User>  addNewUser(@RequestParam String name,@RequestParam String email){
    // @ResponseBody表示返回的String是响应，而不是视图名
    // @RequestParam表示它是来自GET或POST请求的参数
        User newUser=new User();
        newUser.setName(name);
        newUser.setEmail(email);
        userRepository.save(newUser);
        return findAllUser();
    }
    @GetMapping(path = "/findAll")
    public @ResponseBody Iterable<User> findAllUser(){
        return userRepository.findAll();
    }
}
