package lk.easyCar.spring.service.impl;

import lk.easyCar.spring.dto.CustomerDTO;
import lk.easyCar.spring.entity.Customer;
import lk.easyCar.spring.repo.CustomerRepo;
import lk.easyCar.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    ModelMapper mapper;

    @Autowired
    CustomerRepo repo;

    public boolean saveCustomer(CustomerDTO dto){
        if (!repo.existsById(dto.getCustomerID())){
            Customer save = repo.save(mapper.map(dto, Customer.class));
            return true;
        }else{
            throw new RuntimeException("Customer Already in db.");
        }
    }

    public void updateCustomer(CustomerDTO dto) {
        if (repo.existsById(dto.getCustomerID())) {

            repo.save(mapper.map(dto, Customer.class));

        } else {
            throw new RuntimeException("No Such Customer To Update..! Please Check the ID..!");
        }
    }



}
