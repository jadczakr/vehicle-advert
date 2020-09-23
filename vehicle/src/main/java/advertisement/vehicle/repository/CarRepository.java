package advertisement.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import advertisement.vehicle.entities.Car;

public interface CarRepository extends JpaRepository<Car,Integer>
{
	
	
	
}
