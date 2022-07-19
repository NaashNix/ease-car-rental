package lk.easyCar.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CarDTO {
    String carID;
    boolean availability;   // true if available
    String registrationNumber;
    String fuelType;
    String carType;
    String brand;
    String transmissionType;
    String color;
    double currentMeterReading;
    int noOfPassengers;
    double dailyRate;
    double monthlyRate;
    double priceForExtraMile;
}
