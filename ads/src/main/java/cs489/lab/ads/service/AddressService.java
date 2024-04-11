package cs489.lab.ads.service;

import cs489.lab.ads.model.Address;

import java.util.List;

public interface AddressService {
    Address createNewAddress(Address address);
    List<Address> getAllAddresses();
}
