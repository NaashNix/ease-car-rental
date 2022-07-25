package lk.easyCar.spring.service.impl;

import lk.easyCar.spring.dto.OrderRequestDTO;
import lk.easyCar.spring.repo.RequestOrderRepo;
import lk.easyCar.spring.service.RequestOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

        public class RequestOrderServiceImpl implements RequestOrderService {
    @Autowired
    ModelMapper mapper;

    @Autowired
    RequestOrderRepo repo;


    public void saveRequestOrder(OrderRequestDTO dto) {
        if (!repo.existsById(dto.getCarID())){

        }
    }

    public void deleteRequestOrder(String reqOrderID) {

    }

    public void updateRequestOrder(OrderRequestDTO dto) {

    }

    public void searchRequestOrder(String reqOrderID) {

    }

    public List<OrderRequestDTO> getAllRequestOrder() {
        return null;
    }
}
