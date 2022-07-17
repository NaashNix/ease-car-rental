package lk.easyCar.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString
public class Customer {
    @Id
    private String customerID;
    private String username;
    private String password;
    private String fullName;
    private String telephone;
    private String age;
    private String address;
    private String email;
//    private String idCardImage;
//    private String drivingLicenseImage;

}
