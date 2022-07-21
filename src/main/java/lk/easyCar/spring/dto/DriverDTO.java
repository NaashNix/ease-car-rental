package lk.easyCar.spring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DriverDTO {
    private String driverID;
    private String driverName;
    private String driveAge;
    private String driverLicense;
    private String driverTelephone;
    private String driverAddress;
    private String driverLanguage;
}
