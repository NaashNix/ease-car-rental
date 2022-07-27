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
public class InRental {
    @Id
    private String orderID;
    private String reqOrderID;
    private String orderStatus;
    private int carPreMeterReading;
    private Date pickedUpDate;
    private Time pickedUpTime;
    private String specialNotice;

    @OneToOne
    @JoinColumn(name = "reqOrderID", referencedColumnName = "reqOrderID" , insertable = false, updatable = false)
    OrderRequest orderRequest;

}
