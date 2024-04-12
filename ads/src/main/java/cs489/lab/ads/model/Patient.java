package cs489.lab.ads.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
@DiscriminatorValue("patient")
public class Patient extends User{
    private String dob;
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointmentList;
}
