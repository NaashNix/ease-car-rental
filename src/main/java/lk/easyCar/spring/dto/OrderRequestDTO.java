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
public class OrderRequestDTO {
    private String reqOrderID;
    private String carID;
    private String customerID;
    private String driverID;
    private Date requestedDate;
    private Time requestedTime;
    private Date expectedReturnDate;
    private Time expectedReturnTime;
    private double waiverAmount;
    private Status orderStatus;
}
