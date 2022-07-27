package lk.easyCar.spring.service;

import lk.easyCar.spring.dto.OrderRequestDTO;

import java.util.List;

public interface RequestOrderService {

    public void saveRequestOrder(OrderRequestDTO dto);
    public void deleteRequestOrder(String reqOrderID);
    public void updateRequestOrder(OrderRequestDTO dto);
    public OrderRequestDTO searchRequestOrder(String reqOrderID);
    public List<OrderRequestDTO> getAllRequestOrder();
    public void updateOrderStatusByAdmin(String reqOrderID, String status);
}
