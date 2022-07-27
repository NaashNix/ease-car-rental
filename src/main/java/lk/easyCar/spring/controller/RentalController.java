package lk.easyCar.spring.controller;

import lk.easyCar.spring.dto.RentalDTO;
import lk.easyCar.spring.service.RentalService;
import lk.easyCar.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app/rental")
@CrossOrigin
public class RentalController {
    @Autowired
    RentalService service;

    @PostMapping
    public ResponseUtil saveRental(@ModelAttribute RentalDTO dto){
        // Here goes the
        service.saveRental(dto);
        return new ResponseUtil(200,"saved",null);
    }

    @GetMapping
    public ResponseUtil getAllRentals(){

        List<RentalDTO> allRentalDetails = service.getAllRentals();
        return new ResponseUtil(200,"saved",allRentalDetails);

    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateRentalDetails(@RequestBody RentalDTO dto){
        service.updateRental(dto);
        return new ResponseUtil(200,"updated",null);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE , params = {"orderID"})
    public ResponseUtil deleteRentalDetails(@RequestParam String orderID){
        service.deleteRental(orderID);
        return new ResponseUtil(200,"Successfully Deleted",null);
    }

    @GetMapping(path = "/{orderID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchRental(@PathVariable String orderID) {
        return new ResponseUtil(200, "Ok", service.searchRental(orderID));
    }

}
