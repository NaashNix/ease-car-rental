package lk.easyCar.spring.controller;

import lk.easyCar.spring.dto.CarDTO;
import lk.easyCar.spring.dto.CustomerDTO;
import lk.easyCar.spring.service.CarService;
import lk.easyCar.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("app/vehicles")
@CrossOrigin
public class CarController {

    @Autowired
    CarService service;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCar(CarDTO dto){
        service.saveCar(dto);
        return new ResponseUtil(200,"car saved.",null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllVehicles(){
        return new ResponseUtil(200,"OK",service.getAllVehicles());
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateVehicle(@RequestBody CarDTO car){
        service.updateVehicle(car);
        return new ResponseUtil(200,"updated",null);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE , params = {"customerID"})
    public ResponseUtil deleteVehicle(@RequestParam String carID){
        service.deleteVehicle(carID);
        return new ResponseUtil(200,"Successfully Deleted",null);
    }

}
