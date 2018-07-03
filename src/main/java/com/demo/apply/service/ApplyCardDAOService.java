package com.demo.apply.service;

import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.demo.apply.bean.Customer;

@Component
public interface ApplyCardDAOService {
	
	//public long applyCard(Customer customer) throws ApplyCardException;
	public void insertCustomer(Customer customer) throws SQLException;

}
