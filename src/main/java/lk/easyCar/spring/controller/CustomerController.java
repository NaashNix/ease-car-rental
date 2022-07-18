package lk.easyCar.spring.controller;

import lk.easyCar.spring.dto.CustomerDTO;
import lk.easyCar.spring.service.CustomerService;
import lk.easyCar.spring.util.ErrorMessage;
import lk.easyCar.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("app/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService service;

    // Customer Control
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO customer){
        boolean b = service.saveCustomer(customer);
        return new ResponseUtil(200,"saved", ErrorMessage.CUSTOMER_SAVED);
    }
}
