package lk.easyCar.spring.service.impl;

import lk.easyCar.spring.dto.DriverDTO;
import lk.easyCar.spring.entity.Driver;
import lk.easyCar.spring.repo.DriverRepo;
import lk.easyCar.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return mapper.map(repo.findAll(),new TypeToken<DriverDTO>(){}.getType());
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
}
