package lk.easyCar.spring.controller;

import lk.easyCar.spring.dto.CustomerDTO;
import lk.easyCar.spring.service.CustomerService;
import lk.easyCar.spring.util.ErrorMessage;
import lk.easyCar.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;

@RestController
@RequestMapping("app/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/lastID")
    public ResponseUtil getCustomerID (){
        return new ResponseUtil(200,"OK",service.getNextCustomerID());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCustomers() {

        return new ResponseUtil(200, "Ok", service.getAllCustomers());
    }

    // Customer Control
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(@ModelAttribute CustomerDTO customer){
        boolean b = service.saveCustomer(customer);
        return new ResponseUtil(200,"saved", null);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customer){
        service.updateCustomer(customer);
        return new ResponseUtil(200,"updated",null);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE , params = {"customerID"})
    public ResponseUtil deleteCustomer(@RequestParam String customerID){
        service.deleteCustomer(customerID);
        return new ResponseUtil(200,"Successfully Deleted",null);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{customerID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCustomer(@PathVariable String customerID) {
        return new ResponseUtil(200, "Ok", service.searchCustomerByID(customerID));
    }
}
