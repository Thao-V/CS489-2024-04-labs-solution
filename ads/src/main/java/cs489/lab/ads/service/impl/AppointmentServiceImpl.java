package cs489.lab.ads.service.impl;

import cs489.lab.ads.model.Appointment;
import cs489.lab.ads.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl {
    @Autowired
    private AppointmentRepository appointmentRepository;
    public Appointment createAppointment(Appointment appointment){
        return appointmentRepository.save(appointment);
    }
}

