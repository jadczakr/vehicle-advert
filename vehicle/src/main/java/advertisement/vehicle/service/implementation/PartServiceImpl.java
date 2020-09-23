package advertisement.vehicle.service.implementation;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import advertisement.vehicle.repository.PartRepository;
import advertisement.vehicle.service.PartService;

@Service
public class PartServiceImpl implements PartService {

	
	private PartRepository partRepo;
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	public PartServiceImpl(PartRepository partRepo, EntityManager entityManager)
	{
		
		this.entityManager = entityManager;
		this.partRepo = partRepo;
		
	}
}
