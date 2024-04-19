package cs489.lab.ads.model;

import cs489.lab.ads.util.Constants;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
@DiscriminatorValue(Constants.PATIENT)
public class Patient extends User{
    private String dob;
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointmentList;
}
