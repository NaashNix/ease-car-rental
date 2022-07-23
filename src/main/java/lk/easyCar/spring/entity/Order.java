package lk.easyCar.spring.entity;

import lk.easyCar.spring.util.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@IdClass(OrderKey.class)
public class Order {
    @Id
    private String orderID;
    @Id
    private String reqOrderID;
    private Status orderStatus;
    private int carPreMeterReading;
    private Date pickedUpDate;
    private Time pickedUpTime;
    private String specialNotice;

    @OneToOne
    @JoinColumn(name = "reqOrderID", referencedColumnName = "reqOrderID" , insertable = false, updatable = false)
    OrderRequest orderRequest;

}
