package lk.easyCar.spring.service;

import lk.easyCar.spring.dto.CustomerDTO;
import lk.easyCar.spring.entity.Customer;

public interface LoginService {
    public CustomerDTO getCustomerByLogins(String username,String password);
}
