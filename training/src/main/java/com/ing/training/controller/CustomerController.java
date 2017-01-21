package com.ing.training.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ing.training.domain.Customer;
import com.ing.training.service.CustomerManagementService;
import com.ing.training.validator.CustomerDataValidator;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController extends WebMvcConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerManagementService customerService;

    @Autowired
    CustomerDataValidator customerValidator;

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
	binder.addValidators(customerValidator);
    }

    /**
     * This method creates a new user with firstname, lastname, emailaddress
     * etc..
     * 
     * @param customer
     * @return User and HttpStatus
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer, Locale locale) {

	logger.info("customer: " + customer);
	customerService.createCustomer(customer);
	logger.info("customer inserted successfully: " + customer);
	return new ResponseEntity<>(customer, HttpStatus.CREATED);

    }

    /**
     * Get user details by userId
     * 
     * @param customerId
     * @return User Details
     */
    @RequestMapping(value = "/get/{customerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Customer getUserById(@PathVariable int customerId) {

	/*
	 * int i=0; if(i==0) throw new Exception("Error");
	 */

	return customerService.getCustomerById(customerId);

    }

    /**
     * Get user details by userId
     * 
     * @param id
     * @return User Details
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Customer> listUsers() {
	return customerService.listCustomers();

    }

}
