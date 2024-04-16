package cs489.lab.ads.model;

import cs489.lab.ads.util.Constants;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue(Constants.MANAGER)
public class Manager extends User {
    String officePhoneNumber;
}
