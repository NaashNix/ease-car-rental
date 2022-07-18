package lk.easyCar.spring.repo;

import lk.easyCar.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,String> {

}
