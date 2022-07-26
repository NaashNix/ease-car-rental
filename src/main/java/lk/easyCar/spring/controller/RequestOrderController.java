package lk.easyCar.spring.controller;


import lk.easyCar.spring.dto.OrderRequestDTO;
import lk.easyCar.spring.service.RequestOrderService;
import lk.easyCar.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/booking")
@CrossOrigin
public class RequestOrderController {

    @Autowired
    RequestOrderService service;

    @PostMapping
    public ResponseUtil saveRequestOrder(@ModelAttribute OrderRequestDTO dto){
        // Here goes the
        service.saveRequestOrder(dto);
        return new ResponseUtil(200,"saved",null);
    }

    @GetMapping
    public ResponseUtil getAllRequestOrders(){

        List<OrderRequestDTO> allRequestOrder = service.getAllRequestOrder();
        return new ResponseUtil(200,"saved",allRequestOrder);

    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateRequestedOrder(@RequestBody OrderRequestDTO dto){
        service.updateRequestOrder(dto);
        return new ResponseUtil(200,"updated",null);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE , params = {"reqOrderID"})
    public ResponseUtil deleteRequestedOrder(@RequestParam String reqOrderID){
        service.deleteRequestOrder(reqOrderID);
        return new ResponseUtil(200,"Successfully Deleted",null);
    }

    @GetMapping(path = "/{reqOrderID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchRequestedOrder(@PathVariable String reqOrderID) {
        return new ResponseUtil(200, "Ok", service.searchRequestOrder(reqOrderID));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil setStatusToApproved(String reqOrderID){
        service.setStatusToApproved(reqOrderID);
        return new ResponseUtil(200,"set-approved",null);
    }



}
