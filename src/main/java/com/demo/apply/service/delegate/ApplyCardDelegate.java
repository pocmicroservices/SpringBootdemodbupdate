package com.demo.apply.service.delegate;

import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.demo.apply.bean.Customer;
import com.demo.apply.exception.ApplyCardException;
import com.demo.apply.service.ApplyCardDAOService;
import com.demo.apply.service.ApplyCardService;

@Component
public class ApplyCardDelegate implements ApplyCardService{

	//@Qualifier("ApplyCardDAO")
	@Autowired
	ApplyCardDAOService service;
	private Logger logger=LoggerFactory.getLogger(ApplyCardDelegate.class);
	/*@Override
	public long applyCard(Customer customer) throws ApplyCardException {
		logger.info("Call Reached Delegate");
		return service.applyCard(customer);
	}*/
	@Override
	public long applyCard(Customer customer) throws ApplyCardException {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
