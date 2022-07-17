package lk.easyCar.spring.service.impl;

import lk.easyCar.spring.dto.CustomerDTO;
import lk.easyCar.spring.entity.Customer;
import lk.easyCar.spring.repo.LoginRepo;
import lk.easyCar.spring.service.LoginService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    ModelMapper mapper;

    @Autowired
    LoginRepo repo;

    public CustomerDTO getCustomerByLogins(String username,String password) {
        Customer customer = repo.findCustomerByUsernameAndPassword(username, password);

        if (customer == null){
            return null;
        }else{

            return mapper.map(customer,CustomerDTO.class);
        }

    }
}
