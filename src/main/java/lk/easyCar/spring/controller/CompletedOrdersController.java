package lk.easyCar.spring.controller;

import lk.easyCar.spring.dto.CompletedOrdersDTO;
import lk.easyCar.spring.dto.RentalDTO;
import lk.easyCar.spring.service.CompletedOrderService;
import lk.easyCar.spring.service.RentalService;
import lk.easyCar.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app/orders")
@CrossOrigin
public class CompletedOrdersController {
    @Autowired
    CompletedOrderService service;

    @PostMapping
    public ResponseUtil saveRental(@ModelAttribute CompletedOrdersDTO dto){
        // Here goes the
        service.saveCompletedOrder(dto);
        return new ResponseUtil(200,"saved",null);
    }

    @GetMapping
    public ResponseUtil getAllRentals(){

        List<CompletedOrdersDTO> allCompletedOrder = service.getAllCompletedOrder();
        return new ResponseUtil(200,"saved",allCompletedOrder);

    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateRentalDetails(@RequestBody CompletedOrdersDTO dto){
        service.updateCompletedOrder(dto);
        return new ResponseUtil(200,"updated",null);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE , params = {"completedOrderID"})
    public ResponseUtil deleteRentalDetails(@RequestParam String completedOrderID){
        service.deleteCompletedOrder(completedOrderID);
        return new ResponseUtil(200,"Successfully Deleted",null);
    }

    @GetMapping(path = "/{completedOrderID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchRental(@PathVariable String completedOrderID) {
        return new ResponseUtil(200, "Ok", service.searchCompletedOrder(completedOrderID));
    }
}
