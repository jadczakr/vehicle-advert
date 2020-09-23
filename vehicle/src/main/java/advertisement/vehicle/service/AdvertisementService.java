package advertisement.vehicle.service;



import java.util.List;
import java.util.Optional;

import advertisement.vehicle.entities.Advertisement;

public interface AdvertisementService {

	void saveOrUpdate(Advertisement tempAdvert);
	
	Optional<Advertisement> findById(Integer id);
	
	List<Advertisement> getAdvertisementToReactive();
	
	List<Advertisement> findAll();
}
