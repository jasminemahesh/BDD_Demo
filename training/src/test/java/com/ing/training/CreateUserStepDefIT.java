package com.ing.training;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.hamcrest.Matchers.equalTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.training.domain.Customer;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateUserStepDefIT extends SpringIntegrationTest {

    private MockMvc mockMvc;
    ResultActions resultActions = null;
    Customer customer = null;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void init() {
	customer = new Customer();
	
	customer.setLastname("Green");
	customer.setPassword("abcabcabc");
	customer.setGender("Male");
	customer.setPhone("243234324");
	customer.setNationalId("232424333");
	customer.setAddress("Beverly Hills");
	customer.setCountry("United States");
	customer.setPostalCode("93840989");
	customer.setCity("Los Angeles");
	customer.setEmail("rachaelg@gmail.com");
	customer.setAccountType("Current");
	customer.setBalance(10000);
    }
    
    @When("^Create Customer with firstname \"([^\"]*)\"$")
    public void create_Customer_with_firstname(String firstname) throws Throwable {
	customer.setFirstname(firstname);
	mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	resultActions = mockMvc.perform(post("/customer/create").contentType(MediaType.APPLICATION_JSON_UTF8).content(
		new ObjectMapper().writeValueAsBytes(customer)));
    }

    @Then("^A Customer named \"([^\"]*)\" has been created$")
    public void a_Customer_named_has_been_created(String firstname) throws Throwable {
	resultActions.andExpect(status().isCreated()).andExpect(
		content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andExpect(jsonPath("$.firstname", equalTo(firstname)));
    }
    
  

   /* @When("^I call Create Customer Service with mandatory inputs")
    public void the_client_issues_getuserList() throws Exception {

	mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	resultActions = mockMvc.perform(post("/customer/create").contentType(MediaType.APPLICATION_JSON_UTF8).content(
		new ObjectMapper().writeValueAsBytes(customer)));

    }

    @Then("^the create customer receives status code of (\\d+)$")
    public void the_create_customer_receives_status_code_of(int statusCode) throws Throwable {
	resultActions.andExpect(status().is(statusCode)).andExpect(
		content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
	// .andExpect(jsonPath("$.id", equalTo(createdUser.getId())))
	.andExpect(jsonPath("$.firstname", equalTo(customer.getFirstname())))
	.andExpect(jsonPath("$.lastname", equalTo(customer.getLastname())))
	.andExpect(jsonPath("$.city", equalTo(customer.getCity())))
	.andExpect(jsonPath("$.email", equalTo(customer.getEmail())));
	
    }
    
    @Then("^the Customer should be created with status CREATED")
    public void the_create_customer_receives_status_code_of(int statusCode) throws Throwable {
	resultActions.andExpect(status().is(statusCode)).andExpect(
		content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
	// .andExpect(jsonPath("$.id", equalTo(createdUser.getId())))
	.andExpect(jsonPath("$.firstname", equalTo(customer.getFirstname())))
	.andExpect(jsonPath("$.lastname", equalTo(customer.getLastname())))
	.andExpect(jsonPath("$.city", equalTo(customer.getCity())))
	.andExpect(jsonPath("$.email", equalTo(customer.getEmail())));
	
    }
    */
     
     

}
