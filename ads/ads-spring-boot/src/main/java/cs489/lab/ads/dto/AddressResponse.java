package cs489.lab.ads.dto;

public record AddressResponse(
        Integer addressId,
        String address,
        String city,
        String state,
        String zip
) {
}
