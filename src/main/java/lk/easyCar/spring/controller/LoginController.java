package lk.easyCar.spring.controller;

import lk.easyCar.spring.dto.CustomerDTO;
import lk.easyCar.spring.service.LoginService;
import lk.easyCar.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("app/login")
@CrossOrigin
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping(params = {"username","password"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil checkLogin(@RequestParam String username, @RequestParam String password){
        CustomerDTO customerByLogins = loginService.getCustomerByLogins(username, password);

        if (customerByLogins != null){
            return new ResponseUtil(200,"Customer Found.",customerByLogins);
        }else{
            return new ResponseUtil(400,"Customer Not Found.",null);
        }
    }



}
