package lk.easyCar.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomerDTO {
    private String customerID;
    private String username;
    private String password;
    private String fullName;
    private String telephone;
    private String age;
    private String address;
    private String email;
}
