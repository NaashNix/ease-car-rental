package lk.easyCar.spring.repo;

import lk.easyCar.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<Customer,String> {
    public Customer findCustomerByUsernameAndPassword(String username,String password);
}
