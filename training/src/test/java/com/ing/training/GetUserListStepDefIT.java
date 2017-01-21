package com.ing.training;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ing.training.domain.Customer;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GetUserListStepDefIT {

    private MockMvc mockMvc;
    ResultActions resultActions = null;
    Customer customer = null;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @When("^the client calls /customer/list")
    public void the_client_issues_getCustomerList() throws Exception {

	mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	resultActions = mockMvc.perform(get("/customer/list").contentType(MediaType.APPLICATION_JSON_UTF8));

    }

    @Then("^the get list of customers receives status code of (\\d+)$")
    public void the_get_customer_list_receives_status_code_of(int statusCode) throws Throwable {
	resultActions.andExpect(status().is(statusCode)).andExpect(
		content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));

    }

}
