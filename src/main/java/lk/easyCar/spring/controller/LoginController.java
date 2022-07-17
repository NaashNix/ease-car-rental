package lk.easyCar.spring.controller;

import lk.easyCar.spring.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app/login")
@CrossOrigin
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping
    public void checkLogin(){

    }

}
