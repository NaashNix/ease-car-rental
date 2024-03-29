package lk.easyCar.spring.controller;

import lk.easyCar.spring.dto.CarDTO;
import lk.easyCar.spring.service.CarService;
import lk.easyCar.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("app/vehicles")
@CrossOrigin
public class CarController {

    @Autowired
    CarService service;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCar(@ModelAttribute CarDTO dto){
        service.saveCar(dto);
        return new ResponseUtil(200,"car saved.",null);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllVehicles(){
        return new ResponseUtil(200,"OK",service.getAllVehicles());
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateVehicle(@RequestBody CarDTO car){
        service.updateVehicle(car);
        return new ResponseUtil(200,"updated",null);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE , params = {"carID"})
    public ResponseUtil deleteVehicle(@RequestParam String carID){
        service.deleteVehicle(carID);
        return new ResponseUtil(200,"Successfully Deleted",null);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, params = {"reqDate","retDate"})
    public ResponseUtil getAvailableVehiclesOnDate(@RequestParam String reqDate, @RequestParam String retDate){

        return null;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{carID}")
    public ResponseUtil searchVehicle(@PathVariable String carID){
        System.out.println("carID : "+carID);
        return new ResponseUtil(200,"OK",service.searchCar(carID));
    }



}
