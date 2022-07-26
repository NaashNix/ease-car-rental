package lk.easyCar.spring.dto;

import lk.easyCar.spring.util.Status;
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
    private Status orderStatus;
    private int carPreMeterReading;
    private Date pickedUpDate;
    private Time pickedUpTime;
    private String specialNotice;

}
