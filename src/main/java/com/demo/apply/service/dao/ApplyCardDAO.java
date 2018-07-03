package com.demo.apply.service.dao;

import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.demo.apply.bean.Customer;
import com.demo.apply.exception.ApplyCardException;
import com.demo.apply.service.ApplyCardDAOService;

@Component
public class ApplyCardDAO implements ApplyCardDAOService {

	private Logger logger=LoggerFactory.getLogger(ApplyCardDAO.class);
	@Autowired
	JdbcTemplate jdbcTemplate;
	/*public long applyCard(Customer customer) throws ApplyCardException{
		long i=0;
		
		try{
			logger.debug("Call Reached DAO");
		}
		catch(Exception excep){
			throw new ApplyCardException("","","");
		}
		return i;
	}*/

	@Override
	public void insertCustomer(Customer customer) throws SQLException {
		System.out.println("Insert Customer: "+customer.toString());
		String SQL="INSERT into CUSTOMER(firstname,lastname,ssn,email,phonenumber) VALUES(?,?,?,?,?)";
		jdbcTemplate.update(SQL, new Object[]{customer.getFirstName(),customer.getLastName(),customer.getSsn(),customer.getEmail(),customer.getPhoneNumber()});
	}

}
