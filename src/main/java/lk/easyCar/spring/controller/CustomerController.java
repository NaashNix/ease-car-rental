package lk.easyCar.spring.controller;

import lk.easyCar.spring.dto.CustomerDTO;
import lk.easyCar.spring.service.CustomerService;
import lk.easyCar.spring.util.ErrorMessage;
import lk.easyCar.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;

@RestController
@RequestMapping("app/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCustomers() {

        return new ResponseUtil(200, "Ok", service.getAllCustomers());
    }

    // Customer Control
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO customer){
        boolean b = service.saveCustomer(customer);
        return new ResponseUtil(200,"saved", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customer){
        service.updateCustomer(customer);
        return new ResponseUtil(200,"updated",null);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE , params = {"customerID"})
    public ResponseUtil deleteCustomer(@RequestParam String customerID){
        service.deleteCustomer(customerID);
        return new ResponseUtil(200,"Successfully Deleted",null);
    }

    @GetMapping(path = "/{customerID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCustomer(@PathVariable String customerID) {
        return new ResponseUtil(200, "Ok", service.searchCustomerByID(customerID));
    }
}
