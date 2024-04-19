package cs489.lab.ads.service;

import cs489.lab.ads.dto.AddressRequest;
import cs489.lab.ads.dto.AddressResponse;
import cs489.lab.ads.model.Address;
import cs489.lab.ads.repository.AddressRepository;
import cs489.lab.ads.service.impl.AddressServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AddressServiceTest {
    @Mock
    private AddressRepository addressRepository;
    @InjectMocks
    private AddressServiceImpl addressService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createNewAddress() {
        // Given
        AddressRequest request = new AddressRequest("123 Main St", "Springfield", "IL", "62704");
        Address address = new Address(null, "123 Main St", "Springfield", "IL", "62704");
        Address savedAddress = new Address(1, "123 Main St", "Springfield", "IL", "62704");
        when(addressRepository.save(address)).thenReturn(savedAddress);

        // When
        AddressResponse result = addressService.createNewAddress(request);

        // Then
        assertNotNull(result);
        assertEquals(2,result.addressId());
        assertEquals("123 Main St", result.address());
        assertEquals("Springfield", result.city());
        assertEquals("IL", result.state());
        assertEquals("62704", result.zip());
    }
}