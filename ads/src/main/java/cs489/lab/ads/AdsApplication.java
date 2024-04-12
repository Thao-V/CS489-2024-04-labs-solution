package cs489.lab.ads;

import cs489.lab.ads.model.Address;
import cs489.lab.ads.model.Appointment;
import cs489.lab.ads.model.Dentist;
import cs489.lab.ads.model.Patient;
import cs489.lab.ads.service.AddressService;
import cs489.lab.ads.service.UserService;
import cs489.lab.ads.service.impl.AppointmentServiceImpl;
import org.aspectj.weaver.patterns.AndPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class AdsApplication implements CommandLineRunner {

    @Autowired
    private AddressService addressService;
    @Autowired
    private UserService userService;
    @Autowired
    private AppointmentServiceImpl appointmentService;

    public static void main(String[] args) {
        SpringApplication.run(AdsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       //createAddress();
        // getAllAddresses();
        createUser();
    }

    private void createUser(){
        var patient = new Patient();
        patient.setFirstName("Thao");
        patient.setLastName("Vu");
        patient.setDob("10/10/1990");
        var savedPatient = (Patient)userService.createUser(patient);

        var dentist = new Dentist();
        dentist.setFirstName("John");
        dentist.setLastName("Vu");
        dentist.setSpecialization("Orthodentist");
        var savedDentist = (Dentist) userService.createUser(dentist);

        var appointment = new Appointment();
        appointment.setDate(LocalDate.of(2024, 5, 1));
        appointment.setTime(LocalTime.of(10, 30));
        appointment.setDentist(savedDentist);
        appointment.setPatient(savedPatient);

        appointmentService.createAppointment(appointment);

    }

    private void createAddress(){
        var address = new Address(null, "1000 N 4th ST", "Fairfield", "IA", "52556");
        var savedAddress = addressService.createNewAddress(address);
        System.out.println(savedAddress);
    }

    private void getAllAddresses(){
        var res = addressService.getAllAddresses();
        for(Address a: res){
            System.out.println(a);
        }
    }
}
