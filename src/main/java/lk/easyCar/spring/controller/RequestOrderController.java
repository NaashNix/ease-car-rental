package lk.easyCar.spring.controller;

import lk.easyCar.spring.dto.OrderRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/booking")
@CrossOrigin
public class RequestOrderController {



    @PostMapping
    public void requestOrder(@ModelAttribute OrderRequestDTO dto){
        // Here goes the

    }

}
