package lk.easyCar.spring.repo;

import lk.easyCar.spring.entity.OrderRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestOrderRepo extends JpaRepository<OrderRequest, String> {

}
