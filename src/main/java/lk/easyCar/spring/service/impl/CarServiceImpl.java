package lk.easyCar.spring.service.impl;

import lk.easyCar.spring.dto.CarDTO;
import lk.easyCar.spring.entity.Car;
import lk.easyCar.spring.repo.CarRepo;
import lk.easyCar.spring.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

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



    public List<CarDTO> getAllVehicles() {
        return mapper.map(repo.findAll(),new TypeToken<List<CarDTO>>(){}.getType());
    }

    public void updateVehicle(CarDTO dto) {
        if (repo.existsById(dto.getCarID())){
            repo.save(mapper.map(dto,Car.class));
        }else{
            throw new RuntimeException("Car ID is invalid");
        }
    }

    public void deleteVehicle(String carID) {
        if (repo.existsById(carID)){
            repo.deleteById(carID);
        }else{
            throw new RuntimeException("Car ID is invalid");
        }
    }


    public CarDTO searchCar(String carID){
        if (repo.existsById(carID)){
            return mapper.map(repo.findById(carID).get(),CarDTO.class);
        }else {
            throw new RuntimeException("Car not found!");
        }
    }
}
