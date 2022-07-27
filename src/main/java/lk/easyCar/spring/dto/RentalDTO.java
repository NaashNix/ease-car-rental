package lk.easyCar.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RentalDTO {
    private String orderID;
    private String reqOrderID;
    private String orderStatus;
    private int carPreMeterReading;
    private Time pickedUpTime;
    private Date pickedUpDate;
    private String specialNotice;

}
