package com.ing.training;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.equalTo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ing.training.domain.Customer;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GetUserStepDefIT {

    private MockMvc mockMvc;
    ResultActions resultActions = null;
    Customer customer = null;

    @Autowired
    private WebApplicationContext webApplicationContext;
    
    @When("^Get the Customer with Customer Id (\\d+)$")
    public void get_the_Customer_with_Customer_Id(int customerId) throws Throwable {
	mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	resultActions = mockMvc
		.perform(get("/customer/get/" + customerId).contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Then("^A Customer with Customer Id (\\d+) is retrieved$")
    public void a_Customer_with_Customer_Id_is_retrieved(int customerId) throws Throwable {
	resultActions.andExpect(status().isOk()).andExpect(
		content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andExpect(jsonPath("$.accountId", equalTo(customerId)));
    }

    @When("^the client calls /customer/get/(\\d+)$")
    public void the_client_issues_getCustomer(int customerId) throws Exception {

	mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	resultActions = mockMvc
		.perform(get("/customer/get/" + customerId).contentType(MediaType.APPLICATION_JSON_UTF8));

    }

    @Then("^the get customer receives status code of (\\d+)$")
    public void the_get_customer_receives_status_code_of(int statusCode) throws Throwable {
	resultActions.andExpect(status().is(statusCode)).andExpect(
		content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));

    }

}
