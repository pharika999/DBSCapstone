package com.dbs.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.web.beans.SellOrder;
import com.dbs.web.repository.SellOrderRepository;

@Service
public class SellOrderService {
	
	@Autowired
	private SellOrderRepository sellRepo;
	
	
	public boolean insertSellOrder(SellOrder so)	{
		if(this.sellRepo.findById(so.getSellid()).isPresent())
			return false;
		try {
			this.sellRepo.save(so);
		}catch(IllegalArgumentException e )
		{
			return false;
		}
		return true;
	}
}
