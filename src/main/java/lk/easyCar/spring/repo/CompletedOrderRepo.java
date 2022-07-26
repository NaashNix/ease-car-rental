package lk.easyCar.spring.repo;

import lk.easyCar.spring.entity.CompletedOrders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompletedOrderRepo extends JpaRepository<CompletedOrders,String> {
}
