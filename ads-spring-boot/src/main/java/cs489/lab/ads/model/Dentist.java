package cs489.lab.ads.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
@DiscriminatorValue("dentist")
public class Dentist extends User {
    private String specialization;

    @OneToMany(mappedBy = "dentist")
    private List<Appointment> appointmentList;
}
