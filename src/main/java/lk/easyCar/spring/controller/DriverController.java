package lk.easyCar.spring.controller;

import lk.easyCar.spring.dto.CustomerDTO;
import lk.easyCar.spring.dto.DriverDTO;
import lk.easyCar.spring.service.DriverService;
import lk.easyCar.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("app/driver")
@CrossOrigin
public class DriverController {

    @Autowired
    DriverService service;

    // Customer Control
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveDriver(@ModelAttribute DriverDTO driver){
        service.saveDriver(driver);
        return new ResponseUtil(200,"saved", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateDriver(@RequestBody DriverDTO driver){
        service.updateDriver(driver);
        return new ResponseUtil(200,"updated",null);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE , params = {"customerID"})
    public ResponseUtil deleteDriver(@RequestParam String driverID){
        service.deleteDrivers(driverID);
        return new ResponseUtil(200,"Successfully Deleted",null);
    }

}
