package com.ing.training.dao;

import java.util.List;

import com.ing.training.domain.Customer;

public interface CustomerDao {

    /**
     * Create Customer
     * 
     * @param customer
     * @return
     */
    public abstract int createCustomer(Customer customer);

    public abstract Customer getCustomerById(int customerId);

    public abstract List<Customer> listCustomers();

}