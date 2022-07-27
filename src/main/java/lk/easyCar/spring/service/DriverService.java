package lk.easyCar.spring.service;

import lk.easyCar.spring.dto.CarDTO;
import lk.easyCar.spring.dto.CustomerDTO;
import lk.easyCar.spring.dto.DriverDTO;

import java.util.List;

public interface DriverService {

    public void saveDriver(DriverDTO dto);

    List<DriverDTO> getAllDrivers();

    void updateDriver(DriverDTO dto);

    void deleteDrivers(String driverID);

    DriverDTO searchDriverByID (String driverID);
}
