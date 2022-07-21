package lk.easyCar.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
public class RequestedOrder {
    @Id
    private String inquireID;
    private String carID;

}
