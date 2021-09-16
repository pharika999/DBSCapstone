package com.dbs.web.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.web.beans.BuyOrder;
import com.dbs.web.beans.Client;
import com.dbs.web.repository.BuyOrderRepository;

@Service
public class BuyOrderService {

	@Autowired
	private BuyOrderRepository buyRepo;
	


	public BuyOrder getBuyOrderByOrderDate(String id) {
		try { BuyOrder buyorder =
			this.buyRepo.findByOrderDate().get().get(0);

	return buyorder; 
	}
		catch(IllegalArgumentException e ) { return null; } 
	}
	
	public boolean insertBuyOrder(BuyOrder bo)	{
		if(this.buyRepo.findById(bo.getBid()).isPresent())
			return false;
		try {
			this.buyRepo.save(bo);
		}catch(IllegalArgumentException e )
		{
			return false;
		}
		return true;
	}
}
