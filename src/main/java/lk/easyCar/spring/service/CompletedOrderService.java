package lk.easyCar.spring.service;

import lk.easyCar.spring.dto.CompletedOrdersDTO;
import lk.easyCar.spring.dto.RentalDTO;

import java.util.List;

public interface CompletedOrderService {
    public void saveCompletedOrder(CompletedOrdersDTO dto);
    public void deleteCompletedOrder(String completedOrderID);
    public void updateCompletedOrder(CompletedOrdersDTO dto);
    public CompletedOrdersDTO searchCompletedOrder(String completedOrderID);
    public List<CompletedOrdersDTO> getAllCompletedOrder();
}
