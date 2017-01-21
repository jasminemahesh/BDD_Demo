package com.ing.training.dao;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ing.training.domain.Customer;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.ing.training.dao.UserManagementDao#createUser(com.ing.training.domain
     * .User)
     */
    /*
     * CUSTOMER_ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 35434,
     * INCREMENT BY 1) PRIMARY KEY, PASSWORD VARCHAR(10), FIRSTNAME VARCHAR(50),
     * LASTNAME VARCHAR(50), PHONE VARCHAR(15), EMAIL VARCHAR(30), ADDRESS
     * VARCHAR(200), POSTALCODE VARCHAR(12), CITY VARCHAR(50), COUNTRY
     * VACHAR(50)
     */

    @Override
    public int createCustomer(Customer customer) {
	String insertCustomerQuery = "INSERT INTO CUSTOMER(FIRSTNAME, LASTNAME, GENDER, PHONE, EMAIL, NATIONAL_ID, ADDRESS, POSTALCODE, CITY, COUNTRY, ACCOUNT_TYPE, BALANCE) "
		+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
	return jdbcTemplate.update(
		insertCustomerQuery,
		new Object[] { customer.getFirstname(), customer.getLastname(), customer.getGender(), 
			customer.getPhone(), customer.getEmail(), customer.getNationalId(), customer.getAddress(),
			customer.getPostalCode(), customer.getCity(), customer.getCountry() , customer.getAccountType(), customer.getBalance()});

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ing.training.dao.UserManagementDao#getUserById(java.lang.String)
     */
    @Override
    public Customer getCustomerById(int customerId) {
	String getUserByIdQuery = "SELECT * FROM CUSTOMER WHERE ACCOUNT_ID=?";

	return jdbcTemplate.queryForObject(getUserByIdQuery, new Object[] { customerId }, (rs, rowNum) -> {

	    Customer customer = new Customer();
	    customer.setAccountId(rs.getInt("ACCOUNT_ID"));
	    customer.setFirstname(rs.getString("firstname"));
	    customer.setLastname(rs.getString("lastname"));
	    customer.setGender(rs.getString("gender"));
	    customer.setPhone(rs.getString("phone"));
	    customer.setNationalId(rs.getString("national_id"));
	    customer.setAddress(rs.getString("address"));
	    customer.setPostalCode(rs.getString("postalCode"));
	    customer.setCity(rs.getString("city"));
	    customer.setCountry(rs.getString("country"));
	    customer.setAccountType(rs.getString("account_type"));
	    customer.setBalance(rs.getDouble("balance"));
	    customer.setEmail(rs.getString("email"));
	    return customer;

	});

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.ing.training.dao.UserManagementDao#listUsers()
     */
    @Override
    public List<Customer> listCustomers() {
	String getUserByIdQuery = "SELECT * FROM CUSTOMER";
	return jdbcTemplate.query(getUserByIdQuery, (rs, rowNum) -> {

	    Customer customer = new Customer();
	    customer.setAccountId(rs.getInt("ACCOUNT_ID"));
	    customer.setFirstname(rs.getString("firstname"));
	    customer.setLastname(rs.getString("lastname"));
	    customer.setGender(rs.getString("gender"));
	    customer.setPhone(rs.getString("phone"));
	    customer.setNationalId(rs.getString("national_id"));
	    customer.setAddress(rs.getString("address"));
	    customer.setPostalCode(rs.getString("postalCode"));
	    customer.setCity(rs.getString("city"));
	    customer.setCountry(rs.getString("country"));
	    customer.setAccountType(rs.getString("account_type"));
	    customer.setBalance(rs.getDouble("balance"));
	    customer.setEmail(rs.getString("email"));
	    return customer;

	});
    }

}