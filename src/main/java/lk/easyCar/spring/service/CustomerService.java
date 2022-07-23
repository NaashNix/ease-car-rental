package lk.easyCar.spring.service;

import lk.easyCar.spring.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    public boolean saveCustomer(CustomerDTO dto);

    public void updateCustomer(CustomerDTO dto);

    public void deleteCustomer(String id);

    public List<CustomerDTO> getAllCustomers();

    CustomerDTO searchCustomerByID(String customerID);
}
