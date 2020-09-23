package advertisement.vehicle.service.implementation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import advertisement.vehicle.entities.Advertisement;
import advertisement.vehicle.entities.Car;
import advertisement.vehicle.repository.AdvertisementRepository;
import advertisement.vehicle.service.AdvertisementService;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

	
	private AdvertisementRepository advertisementRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	public AdvertisementServiceImpl(EntityManager entityManager, AdvertisementRepository advertRepo)
	{
		this.advertisementRepository = advertRepo;
		this.entityManager = entityManager;
	}

	@Override
	public void saveOrUpdate(Advertisement tempAdvert) {
		
		advertisementRepository.save(tempAdvert);
		
	}

	@Override
	public Optional<Advertisement> findById(Integer id) {
		
		return advertisementRepository.findById(id);
		
	}
	
	

	@Override
	public List<Advertisement> getAdvertisementToReactive() {
			
		
		TypedQuery<Advertisement> query = entityManager.createQuery("from advertisement where activated=:trues and expdata=:today",Advertisement.class);
		
			query
				.setParameter("trues", true)
				.setParameter("today", LocalDate.now());
			
			return query.getResultList();	
		
	}

	@Override
	public List<Advertisement> findAll() {
		
		return advertisementRepository.findAll();
		
	}
}
