package cs489.lab.ads.service.impl;

import cs489.lab.ads.model.Location;
import cs489.lab.ads.repository.LocationRepository;
import cs489.lab.ads.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;
    @Override
    public Location createLocation(Location location) {
        return locationRepository.save(location);
    }
}
