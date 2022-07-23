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
@Data
@ToString
@Entity
public class CompletedOrders {
    @Id
    private String completedOrderID;
    private String orderID;
    private Time returnedTime;
    private Date returnedDate;
    private int carPostMeterReading;
    private double wholeDistance;
    private double rentalPrice;
    private double extraTimeCharge;
    private double debitedWaiverAmount;


    @OneToOne
    @JoinColumn(name = "orderID", referencedColumnName = "orderID", insertable = false, updatable = false)
    private InRental inRental;
}
