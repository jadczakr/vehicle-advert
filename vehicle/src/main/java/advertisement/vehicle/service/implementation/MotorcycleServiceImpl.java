package advertisement.vehicle.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import advertisement.vehicle.entities.Car;
import advertisement.vehicle.entities.Motorcycle;
import advertisement.vehicle.repository.MotorcycleRepository;
import advertisement.vehicle.service.MotorcycleService;

@Service
public class MotorcycleServiceImpl implements MotorcycleService {


	private MotorcycleRepository motorcycleRepo;
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	public MotorcycleServiceImpl(MotorcycleRepository motorcycleRepo, EntityManager entityManager)
	{
		this.motorcycleRepo = motorcycleRepo;
		this.entityManager = entityManager;
	}

	@Override
	public void saveOrUpdateMotorcycle(Motorcycle tempMotorcycle) {
		
		motorcycleRepo.save(tempMotorcycle);
		
	}

	@Override
	public List<Motorcycle> getMotorcycleList() {
		
		return motorcycleRepo.findAll();
	}

	@Override
	public Optional<Motorcycle> getMotorcycleById(Integer id) {
		
		return motorcycleRepo.findById(id);
	}

	@Override
	public Motorcycle getMotorcycleByAdvertisementNumb(Integer id) {

		List<Motorcycle> tempListMotorcycle = entityManager.createQuery("from motorcycle where advertisement_id=:advertid").setParameter("advertid", id).getResultList();
		
		if(tempListMotorcycle!=null)
		{
			return tempListMotorcycle.get(0);
		}
		else
		{
			return null;
		}
	}
	
	/*
	@Override
	public List<Optional<Motorcycle>> getRandomizeMotorcycles() {
		
		List <Optional<Motorcycle>> tempList = null;
		int amount = getMotorcycleList().size();
		Optional<Motorcycle> tempCar;
		for(int i = 0 ; i<5 ; i++)
			{
				tempCar = motorcycleRepo.findById(ThreadLocalRandom.current().nextInt(1, amount + 1));
				if(tempCar.isPresent())
				{
					tempList.add(tempCar);
				}
				else
				{
					i--;
				}
			}
		
		return tempList;
	}
	*/
}

