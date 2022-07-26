package lk.easyCar.spring.service.impl;

import lk.easyCar.spring.dto.CompletedOrdersDTO;
import lk.easyCar.spring.dto.RentalDTO;
import lk.easyCar.spring.entity.CompletedOrders;
import lk.easyCar.spring.entity.InRental;
import lk.easyCar.spring.repo.CompletedOrderRepo;
import lk.easyCar.spring.service.CompletedOrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompletedOrdersImpl implements CompletedOrderService {

    @Autowired
    ModelMapper mapper;

    @Autowired
    CompletedOrderRepo repo;

    public void saveCompletedOrder(CompletedOrdersDTO dto) {
        if (!repo.existsById(dto.getOrderID())) {
            repo.save(mapper.map(dto, CompletedOrders.class));
        } else {
            throw new RuntimeException("Same ID exists in the `CompletedOrders` table!");
        }
    }

    public void deleteCompletedOrder(String completedOrderID) {
        if (repo.existsById(completedOrderID)) {
            repo.deleteById(completedOrderID);
        } else {
            throw new RuntimeException("CompletedOrderID not found!");
        }
    }

    public void updateCompletedOrder(CompletedOrdersDTO dto) {
        if (repo.existsById(dto.getOrderID())) {
            repo.save(mapper.map(dto, CompletedOrders.class));
        } else {
            throw new RuntimeException("No any same ID found in `CompletedOrders` table!");
        }
    }

    public CompletedOrdersDTO searchCompletedOrder(String completedOrderID) {
        if (repo.existsById(completedOrderID)) {
            return mapper.map(repo.findById(completedOrderID), CompletedOrdersDTO.class);
        } else {
            throw new RuntimeException("completedOrderID not found in DB!");
        }
    }

    public List<CompletedOrdersDTO> getAllCompletedOrder() {
        return mapper.map(repo.findAll(), new TypeToken<CompletedOrdersDTO>() {
        }.getType());
    }
}
