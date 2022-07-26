package lk.easyCar.spring.service.impl;


import lk.easyCar.spring.dto.RentalDTO;
import lk.easyCar.spring.entity.InRental;
import lk.easyCar.spring.repo.RentalRepo;
import lk.easyCar.spring.service.RentalService;
import lk.easyCar.spring.service.RequestOrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RentalServiceImpl implements RentalService {
    @Autowired
    ModelMapper mapper;

    @Autowired
    RentalRepo repo;

    RequestOrderService requestOrderService;


    public void saveRental(RentalDTO dto) {
        requestOrderService.setStatusToInJourney(dto.getReqOrderID());
        if (!repo.existsById(dto.getOrderID())) {
            repo.save(mapper.map(dto, InRental.class));
        } else {
            throw new RuntimeException("Same orderID exists in the `InRental` table!");
        }
    }

    public void deleteRental(String orderID) {
        if (repo.existsById(orderID)) {
            repo.deleteById(orderID);
        } else {
            throw new RuntimeException("Order ID not found!");
        }
    }

    public void updateRental(RentalDTO dto) {
        if (repo.existsById(dto.getOrderID())) {
            repo.save(mapper.map(dto, InRental.class));
        } else {
            throw new RuntimeException("No any same orderID found in `InRental` table!");
        }
    }

    public RentalDTO searchRental(String orderID) {
        if (repo.existsById(orderID)) {
            return mapper.map(repo.findById(orderID), RentalDTO.class);
        } else {
            throw new RuntimeException("orderID not found in DB!");
        }
    }

    public List<RentalDTO> getAllRentals() {
        return mapper.map(repo.findAll(), new TypeToken<RentalDTO>() {
        }.getType());
    }
}
