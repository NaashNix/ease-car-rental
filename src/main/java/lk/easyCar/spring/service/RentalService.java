package lk.easyCar.spring.service;

import lk.easyCar.spring.dto.OrderRequestDTO;
import lk.easyCar.spring.dto.RentalDTO;

import java.util.List;

public interface RentalService {
    public void saveRental(RentalDTO dto);
    public void deleteRental(String orderID);
    public void updateRental(RentalDTO dto);
    public RentalDTO searchRental(String orderID);
    public List<RentalDTO> getAllRentals();
}
