package com.ing.training.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ing.training.domain.Customer;

@Component
public class CustomerDataValidator implements Validator{

	//@Override
	public boolean supports(Class<?> clazz) {
		return Customer.class.isAssignableFrom(clazz);
	}

	//@Override
	public void validate(Object target, Errors errors) {
		Customer customer =(Customer)target;
		
		String email=customer.getEmail();
		
		if(email!=null && email.indexOf('@')==-1)
		{
			errors.rejectValue("email", "error.invalid.email");
				
		}
		
	}
	
	

}
