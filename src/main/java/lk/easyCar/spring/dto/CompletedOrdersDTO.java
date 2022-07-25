package lk.easyCar.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class CompletedOrdersDTO {
    private String completedOrderID;
    private String orderID;
    private Time returnedTime;
    private Date returnedDate;
    private int carPostMeterReading;
    private double wholeDistance;
    private double rentalPrice;
    private double extraTimeCharge;
    private double debitedWaiverAmount;
}
