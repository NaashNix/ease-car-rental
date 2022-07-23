package lk.easyCar.spring.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/booking")
@CrossOrigin
public class RequestOrderController {

    @PostMapping
    public void requestOrder(){

    }

}
