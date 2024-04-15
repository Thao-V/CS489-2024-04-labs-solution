package cs489.lab.ads.service;

import cs489.lab.ads.dto.AddressRequest;
import cs489.lab.ads.dto.AddressResponse;
import cs489.lab.ads.model.Address;

import java.util.List;

public interface AddressService {
    AddressResponse createNewAddress(AddressRequest addressRequest);
    List<AddressResponse> getAllAddresses();
}
