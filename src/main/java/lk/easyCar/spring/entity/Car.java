package lk.easyCar.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString
public class Car {
    @Id
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
