package lk.easyCar.spring.service.impl;


import lk.easyCar.spring.dto.OrderRequestDTO;
import lk.easyCar.spring.entity.OrderRequest;
import lk.easyCar.spring.repo.RequestOrderRepo;
import lk.easyCar.spring.service.RequestOrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RequestOrderServiceImpl implements RequestOrderService {
    @Autowired
    ModelMapper mapper;

    @Autowired
    RequestOrderRepo repo;


    public void saveRequestOrder(OrderRequestDTO dto) {
        if (!repo.existsById(dto.getCarID())){
           repo.save(mapper.map(dto, OrderRequest.class));
        }else{
            throw new RuntimeException("Order ID already saved!");
        }
    }

    public void deleteRequestOrder(String reqOrderID) {
        if (repo.existsById(reqOrderID)){
            repo.deleteById(reqOrderID);
        }else{
            throw new RuntimeException("Order ID not found!");
        }
    }

    public void updateRequestOrder(OrderRequestDTO dto) {
        if (repo.existsById(dto.getCarID())){
            repo.save(mapper.map(dto, OrderRequest.class));
        }else{
            throw new RuntimeException("Order ID already saved!");
        }
    }

    public OrderRequestDTO searchRequestOrder(String reqOrderID) {
        if (repo.existsById(reqOrderID)){
            return mapper.map(repo.findById(reqOrderID), OrderRequestDTO.class);
        }else{
            throw new RuntimeException("Customer ID already saved!");
        }
    }

    public List<OrderRequestDTO> getAllRequestOrder() {
        return mapper.map(repo.findAll(),new TypeToken<OrderRequestDTO>(){}.getType());
    }
}
