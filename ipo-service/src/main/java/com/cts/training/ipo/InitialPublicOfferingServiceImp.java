package com.cts.training.ipo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InitialPublicOfferingServiceImp implements InitialPublicOfferingService 
{

	@Autowired
	InitialPublicOfferingDAO initialPublicOfferingDAO;
	
	@Autowired
	InitialPublicOfferingService initialPublicOfferingService;

	@Override
	public InitialPublicOffering insert(InitialPublicOffering initialPublicOffering)
	{
		initialPublicOfferingDAO.save(initialPublicOffering);
		return initialPublicOffering;
	}
	

	@Override
	public void delete(int id) 
	{
		initialPublicOfferingDAO.deleteById(id);
	}

	@Override
	public InitialPublicOffering updateInitialPublicOffering(InitialPublicOffering initialPublicOffering) {
		
		initialPublicOfferingDAO.save(initialPublicOffering);
		return initialPublicOffering;	
	}

	@Override
	public List<InitialPublicOffering> getAllInitialPublicOfferings() {
		
		return initialPublicOfferingDAO.findAll();
	}

	@Override
	public InitialPublicOffering getInitialPublicOfferingById(int id) {
		Optional<InitialPublicOffering> initialPublicOffering =initialPublicOfferingDAO.findById(id);
		return initialPublicOffering.orElse(null);
	}
	
}
