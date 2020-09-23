package advertisement.vehicle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import advertisement.vehicle.entities.Car;

public interface CarService {

	void saveOrUpdateCar(Car tempCar);
	
	List<Car> getCarList();
	
	Optional<Car> getCarById(Integer id);
	
	// List<Optional<Car>> getRandomizeCars();
	
	Car getCarByAdvertisementNumb(Integer id);
	
	List<String> wyposazenieDodatkowe(Integer id);
	
	List<String> getPhotos(Integer id);
	
	Car getPhotosByAdvertisementId(Integer id);
	
	Page<Car> findPaginated(int pageNo, int pageSize);
	
	List<Car> findLastTenRows();

}
