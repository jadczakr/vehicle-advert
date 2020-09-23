package advertisement.vehicle.service;

import java.util.List;
import java.util.Optional;

import advertisement.vehicle.entities.Motorcycle;

public interface MotorcycleService {

	void saveOrUpdateMotorcycle(Motorcycle tempMotorcycle);
	
	List<Motorcycle> getMotorcycleList();
	
	Optional<Motorcycle> getMotorcycleById(Integer id);
	
	Motorcycle getMotorcycleByAdvertisementNumb(Integer id);
	
	
	
}
