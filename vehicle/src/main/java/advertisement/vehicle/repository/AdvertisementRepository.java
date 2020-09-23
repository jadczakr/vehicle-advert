package advertisement.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import advertisement.vehicle.entities.Advertisement;

public interface AdvertisementRepository extends JpaRepository<Advertisement,Integer>{

}
