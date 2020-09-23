package advertisement.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import advertisement.vehicle.entities.Motorcycle;

public interface MotorcycleRepository extends JpaRepository<Motorcycle,Integer>{

	
}
