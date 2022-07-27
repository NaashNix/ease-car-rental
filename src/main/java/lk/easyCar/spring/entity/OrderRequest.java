package lk.easyCar.spring.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@ToString
public class OrderRequest {
    @Id
    private String reqOrderID;
    private String carID;
    private String customerID;
    private String driverID;
    private Date requestedDate;
    private Time requestedTime;
    private Date expectedReturnDate;
    private Time expectedReturnTime;
    private double waiverAmount;
    private String orderStatus;


    @ManyToOne
    @JoinColumn(name = "driverID", referencedColumnName = "driverID", insertable = false, updatable = false)
    Driver driver;

    @ManyToOne
    @JoinColumn(name = "customerID", referencedColumnName = "customerID", insertable = false, updatable = false)
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "carID", referencedColumnName = "carID", insertable = false, updatable = false)
    Car car;


}
