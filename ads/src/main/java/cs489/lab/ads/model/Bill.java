package cs489.lab.ads.model;

import cs489.lab.ads.util.BillStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer billId;
    private double amount;
    private BillStatus status = BillStatus.UNPAID;//unpaid, paid

    @ManyToMany()
    @JoinTable(name = "bills_appointments",
            joinColumns = {@JoinColumn(name = "bill_id", referencedColumnName = "billId")},
            inverseJoinColumns = {@JoinColumn(name="appointment_id", referencedColumnName = "appointmentId")}
            )
    private Set<Appointment> appointments = new HashSet<>();
    public void addAppointment(Appointment appointment){
        appointments.add(appointment);
    }
}
