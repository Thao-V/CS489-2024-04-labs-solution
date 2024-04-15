package cs489.lab.ads.controller;

import cs489.lab.ads.dto.AddressRequest;
import cs489.lab.ads.dto.AddressResponse;
import cs489.lab.ads.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;
    @PostMapping("")
    public ResponseEntity<AddressResponse> createAddress(@RequestBody @Valid AddressRequest addressRequest){
        return ResponseEntity.ok(addressService.createNewAddress(addressRequest));
    }
    @GetMapping("")
    public ResponseEntity<List<AddressResponse>> getAllAddresses(){
        return ResponseEntity.ok(addressService.getAllAddresses());
    }
}
