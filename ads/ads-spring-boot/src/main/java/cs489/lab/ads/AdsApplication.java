package cs489.lab.ads;

import cs489.lab.ads.model.*;
import cs489.lab.ads.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class AdsApplication{
    public static void main(String[] args) {
        SpringApplication.run(AdsApplication.class, args);
    }
}
//@SpringBootApplication
//public class AdsApplication implements CommandLineRunner {
//
//    @Autowired
//    private AddressService addressService;
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private AppointmentService appointmentService;
//    @Autowired
//    private LocationService locationService;
//    @Autowired
//    private BillService billService;
//
//    public static void main(String[] args) {
//        SpringApplication.run(AdsApplication.class, args);
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        createAppointment();
//    }
//
//    private void createAppointment(){
//        var patientAddr = new Address(null, "1000 N 4th ST", "Fairfield", "IA", "52556");
//        var savedPatientAddress = addressService.createNewAddress(patientAddr);
//
//        var dentistAddress = new Address(null, "200 Main ST", "Fairfield", "IA", "52556");
//        var savedDentistAddress = addressService.createNewAddress(dentistAddress);
//
//        var clinicAddress = new Address(null, "200 2nd ST", "Fairfield", "IA", "52556");
//        var savedClinicAddress = addressService.createNewAddress(clinicAddress);
//
//        var location = new Location(null, "123-456-0001", "Fairfield Dental Clinics", savedClinicAddress, null);
//        var savedLocation = locationService.createLocation(location);
//
//        var patient = new Patient();
//        patient.setFirstName("Thao");
//        patient.setLastName("Vu");
//        patient.setDob("10/10/1990");
//        patient.setAddress(savedPatientAddress);
//        var savedPatient = (Patient)userService.createUser(patient);
//
//        var dentist = new Dentist();
//        dentist.setFirstName("John");
//        dentist.setLastName("Vu");
//        dentist.setSpecialization("Orthodontist");
//        dentist.setAddress(savedDentistAddress);
//        var savedDentist = (Dentist) userService.createUser(dentist);
//
//        var appointment = new Appointment();
//        appointment.setDate(LocalDate.of(2024, 5, 1));
//        appointment.setTime(LocalTime.of(10, 30));
//        appointment.setDentist(savedDentist);
//        appointment.setPatient(savedPatient);
//        appointment.setLocation(savedLocation);
//        var savedAppointment = appointmentService.createAppointment(appointment);
//
//        var bill = new Bill();
//        bill.setAmount(100.00);
//        bill.addAppointment(savedAppointment);
//        billService.createBill(bill);
//    }
//
//    private void createAddress(){
//        var address = new Address(null, "1000 N 4th ST", "Fairfield", "IA", "52556");
//        var savedAddress = addressService.createNewAddress(address);
//        System.out.println(savedAddress);
//    }
//
//    private void getAllAddresses(){
//        var res = addressService.getAllAddresses();
//        for(Address a: res){
//            System.out.println(a);
//        }
//    }
//}
