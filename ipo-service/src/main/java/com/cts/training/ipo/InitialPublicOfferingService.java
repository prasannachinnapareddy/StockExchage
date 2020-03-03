package com.cts.training.ipo;

import java.util.List;

public interface InitialPublicOfferingService 
{
	public InitialPublicOffering insert(InitialPublicOffering initialPublicOffering);
	
	public void delete(int id);
	
	public InitialPublicOffering updateInitialPublicOffering(InitialPublicOffering initialPublicOffering);
	
	public List<InitialPublicOffering> getAllInitialPublicOfferings();
	
	public InitialPublicOffering getInitialPublicOfferingById(int id);
	
}
