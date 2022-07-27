package lk.easyCar.spring.service.impl;

import lk.easyCar.spring.dto.CustomerDTO;
import lk.easyCar.spring.dto.DriverDTO;
import lk.easyCar.spring.entity.Customer;
import lk.easyCar.spring.entity.Driver;
import lk.easyCar.spring.repo.DriverRepo;
import lk.easyCar.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    ModelMapper mapper;

    @Autowired
    DriverRepo repo;


    public void saveDriver(DriverDTO dto) {
        if (!repo.existsById(dto.getDriverID())){
            repo.save(mapper.map(dto, Driver.class));
        }else{
            throw new RuntimeException("Driver already in the DB");
        }
    }

    public List<DriverDTO> getAllDrivers() {
        List<Driver> all = repo.findAll();
        List<DriverDTO> driverDTOS = new ArrayList<>();
        for (Driver driver : all) {
            driverDTOS.add(
              new DriverDTO(
                      driver.getDriverID(),
                      driver.getDriverName(),
                      driver.getDriveAge(),
                      driver.getDriverLicense(),
                      driver.getDriverTelephone(),
                      driver.getDriverAddress(),
                      driver.getDriverLanguage()
              ));
        }

        return driverDTOS;
    }

    public void updateDriver(DriverDTO dto) {
        if (repo.existsById(dto.getDriverID())){
            repo.save(mapper.map(dto,Driver.class));
        }else{
            throw new RuntimeException("Driver not exists");
        }
    }

    public void deleteDrivers(String driverID) {
        if (repo.existsById(driverID)){
            repo.deleteById(driverID);
        }else {
            throw new RuntimeException("Driver not exists");
        }
    }

    public DriverDTO searchDriverByID(String driverID){
        if (repo.findById(driverID).isPresent()) {
            Driver driver = repo.findById(driverID).get();
            return mapper.map(driver,DriverDTO.class);
        }else{
            throw new RuntimeException("driverID is wrong!");
        }

    }
}
