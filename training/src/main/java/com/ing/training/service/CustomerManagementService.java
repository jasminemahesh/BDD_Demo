package com.ing.training.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ing.training.dao.CustomerDao;
import com.ing.training.domain.Customer;
import com.ing.training.exception.CustomerCreationException;
import com.ing.training.exception.CustomerFetchException;

@Service
public class CustomerManagementService {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerManagementService.class);
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	CustomerDao customerDao;
	
					
	public int createCustomer(Customer user)
	{
		try
		{
		
		return customerDao.createCustomer(user);
		
		}
		catch(DataAccessException dae)
		{
			Locale locale=new Locale("en", "IN");
			String errorMsg=messageSource.getMessage("error.create.customer", new Object[] {}, locale);
			logger.error(errorMsg, dae);
			throw new CustomerCreationException(errorMsg, dae);
		}
	}
	
	public Customer getCustomerById(int customerId)
	{
		//return populateUser(id);
		
		Customer user=new Customer();
		try
		{
		user=customerDao.getCustomerById(customerId);
		}
		catch(DataAccessException dae)
		{
			logger.error("Error in Fetching Customer Details for Customer Id: "+ customerId , dae);
			throw new CustomerFetchException("Error in Fetching Customer Details for Customer Id: "+ customerId, dae);
		}
		return user;
	}
	
	public List<Customer> listCustomers()
	{
		List<Customer> customerList=new ArrayList<>();
		try
		{
			customerList=customerDao.listCustomers();
		}
		catch(DataAccessException dae)
		{
			logger.error("No User Found", dae);
			throw new CustomerFetchException("No User Found", dae);
		}
		return customerList;
	}
	
	
}
