package lk.easyCar.spring.service;

import lk.easyCar.spring.dto.CarDTO;

import java.util.List;

public interface CarService {

    public void saveCar(CarDTO dto);

    List<CarDTO> getAllVehicles();

    void updateVehicle(CarDTO dto);

    void deleteVehicle(String carID);

}
