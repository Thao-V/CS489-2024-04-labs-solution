package cs489.lab.ads;

import cs489.lab.ads.model.Address;
import cs489.lab.ads.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdsApplication implements CommandLineRunner {

    @Autowired
    private AddressService addressService;

    public static void main(String[] args) {
        SpringApplication.run(AdsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       //createAddress();
        getAllAddresses();
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
