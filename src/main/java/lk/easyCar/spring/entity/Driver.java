package lk.easyCar.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Driver {
    @Id
    private String driverID;
    private String driverName;
    private String driveAge;
    private String driverLicense;
    private String driverTelephone;
    private String driverAddress;
    private String driverLanguage;

}
