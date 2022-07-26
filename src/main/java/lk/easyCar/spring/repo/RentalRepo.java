package lk.easyCar.spring.repo;

import lk.easyCar.spring.entity.InRental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepo extends JpaRepository<InRental,String> {
}
