package lk.easyCar.spring.service.impl;

import lk.easyCar.spring.dto.CarDTO;
import lk.easyCar.spring.entity.Car;
import lk.easyCar.spring.repo.CarRepo;
import lk.easyCar.spring.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    ModelMapper mapper;

    @Autowired
    CarRepo repo;

    public void saveCar(CarDTO dto) {
        if (!repo.existsById(dto.getCarID())) {
            repo.save(mapper.map(dto, Car.class));
        }else{
            throw new RuntimeException("Car already in the db.");
        }
    }
}
