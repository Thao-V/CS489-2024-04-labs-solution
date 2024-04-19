package cs489.lab.ads.service.impl;

import cs489.lab.ads.dto.AddressRequest;
import cs489.lab.ads.dto.AddressResponse;
import cs489.lab.ads.model.Address;
import cs489.lab.ads.repository.AddressRepository;
import cs489.lab.ads.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Override
    public AddressResponse createNewAddress(AddressRequest addressRequest){
        var address = new Address();
        address.setAddress(addressRequest.address());
        address.setCity(addressRequest.city());
        address.setState(addressRequest.state());
        address.setZip(addressRequest.zip());
        var savedAddress = addressRepository.save(address);
        return new AddressResponse(
                savedAddress.getAddressId(),
                savedAddress.getAddress(),
                savedAddress.getCity(),
                savedAddress.getState(),
                savedAddress.getZip()
        );
    }

    @Override
    public List<AddressResponse> getAllAddresses() {
        return addressRepository.findAll().stream().
                map(a -> new AddressResponse(
                        a.getAddressId(),
                        a.getAddress(),
                        a.getCity(),
                        a.getState(),
                        a.getZip()
                )).toList();
    }
}
