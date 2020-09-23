package advertisement.vehicle.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import advertisement.vehicle.entities.Car;
import advertisement.vehicle.repository.CarRepository;
import advertisement.vehicle.service.CarService;

@Service
public class CarServiceImpl implements CarService {

	private CarRepository carRepo;
	
	
	private EntityManager entityManager;
	
	@Autowired
	public CarServiceImpl(CarRepository carRepo, EntityManager entityManager)
	{
		this.carRepo = carRepo;
		this.entityManager = entityManager;
	}

	@Override
	public void saveOrUpdateCar(Car tempCar) {
		carRepo.save(tempCar);
	}

	
	// do poprawy
	@Override
	public List<Car> getCarList() {
		
		 List<Car> tempList = new ArrayList<Car>();
		 
		 
		 for(Car tempCar : carRepo.findAll())
		 {
			 if(tempCar.getAdvertisement().isActivated())
		 		{
				 	tempList.add(tempCar);
			     }
		 }
				 
		 return tempList;
	}
	

	@Override
	public Optional<Car> getCarById(Integer id) {
		return carRepo.findById(id);
	}

	@Override
	public Car getCarByAdvertisementNumb(Integer id) {
	
		List<Car> tempListCar = entityManager.createQuery("from car where advertisement_id=:advertid").setParameter("advertid", id).getResultList();
		
		if(tempListCar!=null)
		{
			return tempListCar.get(0);
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<String> wyposazenieDodatkowe(Integer id) {
		
		return entityManager.createQuery("select additionalEquipment from car where advertisement_id=:ajdi").setParameter("ajdi", id).getResultList();
		
	}

	@Override
	public List<String> getPhotos(Integer id) {
		
		TypedQuery<Car> query = entityManager.createQuery("select c from car where advertisement_id=:ajdi",Car.class);
		
		return null;
	}

	@Override
	public Car getPhotosByAdvertisementId(Integer id) {
		
		TypedQuery<Car> query = entityManager.createQuery("from car where advertisement_id=:ajdi",Car.class);
			query.setParameter("ajdi", id);
			
		List<Car> tempListCar = query.getResultList();
		
		if(!tempListCar.isEmpty())
		{
			return tempListCar.get(0);
		}
		else
			return null;
		
	}

	@Override
	public Page<Car> findPaginated(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize) ;
		
		
		return this.carRepo.findAll(pageable);
	}

	@Override
	public List<Car> findLastTenRows() {
		
		TypedQuery<Car> query = entityManager.createQuery("from car order by id asc",Car.class);
		
		List<Car> lista = query.setMaxResults(10).getResultList();
		
		return lista;
	}

	
	/*
	@Override
	public List<Optional<Car>> getRandomizeCars() {
		
		List <Optional<Car>> tempList = null;
		int amount = getCarList().size();
		Optional<Car> tempCar;
		for(int i = 0 ; i<5 ; i++)
			{
				tempCar = carRepo.findById(ThreadLocalRandom.current().nextInt(1, amount + 1));
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
