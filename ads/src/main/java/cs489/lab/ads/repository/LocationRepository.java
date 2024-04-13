package cs489.lab.ads.repository;

import cs489.lab.ads.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
