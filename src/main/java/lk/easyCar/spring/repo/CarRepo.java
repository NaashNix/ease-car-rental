package lk.easyCar.spring.repo;

import lk.easyCar.spring.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car,String> {

}
