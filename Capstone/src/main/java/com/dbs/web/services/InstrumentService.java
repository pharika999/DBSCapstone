package com.dbs.web.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import com.dbs.web.beans.Custodian;
import com.dbs.web.beans.Instrument;
import com.dbs.web.repository.InstrumentRepository;

public class InstrumentService {
	
	@Autowired
	private InstrumentRepository instRepo;
	
	public Instrument findInstrumentById(String id)
	{
		try {
			Optional<Instrument> instrument = this.instRepo.findById(id);

			return instrument.orElseThrow(()->{

				return new EntityNotFoundException("Instrument with "+id + " does not exist");
			});

		}catch(IllegalArgumentException e )
		{
			return null;
		}
	}
	

}
