package lk.easyCar.spring.service;

import lk.easyCar.spring.dto.CustomerDTO;

public interface CustomerService {

    public boolean saveCustomer(CustomerDTO dto);

    public void updateCustomer(CustomerDTO dto);

}
