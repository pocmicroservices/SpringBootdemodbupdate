package com.demo.apply.service;

import com.demo.apply.bean.Customer;
import com.demo.apply.exception.ApplyCardException;

public interface ApplyCardService {

	public long applyCard(Customer customer) throws ApplyCardException;
}
