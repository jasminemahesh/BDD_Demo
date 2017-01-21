package com.ing.training.ui;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GetAllCustomerIT {

    private WebDriver driver;

    private static final int TIMEOUT = 10;

    @Before
    public void setup() {
	/*final DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
	capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

	final File file = new File(
		"D:\\backup\\Projects\\Demo\\spring-mvc-webapp-master\\src\\test\\resources\\IEDriverServer.exe");

	System.setProperty("webdriver.ie.driver", file.getAbsolutePath());

	driver = new InternetExplorerDriver(capabilities);*/

	

    }

    /**
     * Given.
     * 
     * @param arg1
     *            param
     * @param arg2
     *            param
     * @throws Throwable
     *             thrown
     */
    @Given("^the search criteria is \"([^\"]*)\" customerid \"([^\"]*)\"$")
    public void theSearchCriteriaIsCustomerId(String validOrInvalid, String customerId) throws Throwable {

	final DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
	capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

	final File file = new File(
		"D:\\backup\\Projects\\Demo\\spring-mvc-webapp-master\\src\\test\\resources\\IEDriverServer.exe");

	System.setProperty("webdriver.ie.driver", file.getAbsolutePath());

	driver = new InternetExplorerDriver(capabilities);
	
	driver.get("http://localhost:8080/training-1.0.0-BUILD-SNAPSHOT/");
	
	// Find the text input element by its name
	WebElement element = driver.findElement(By.id("search"));

	// Enter something to search for
	element.sendKeys(customerId);

    }

    @When("^the \"([^\"]*)\" button is clicked$")
    public void theSearchByIdButtonClicked(String searchButton) throws Throwable {

	
	// Find the text input element by its name
	WebElement element = driver.findElement(By.id(searchButton));

	// Enter something to search for
	element.sendKeys(Keys.ENTER);
	new WebDriverWait(driver, 60, 120);

    }
            
    @Then("^the customer details for \"([^\"]*)\" is retrieved$")
    public void the_customer_details_for_customerId_is_retrieved(String customerId) throws Throwable {

	// Find the text input element by its name
	WebElement element = driver.findElement(By.id("info"));
	assertTrue(element.getText().contains(customerId));

	//new WebDriverWait(driver, 60, 120);
	
	driver.close();

    }

    @Then("^the error \"([^\"]*)\" is shown$")
    public void the_error_is_shown(String error) throws Throwable {

	// Find the text input element by its name
	WebElement element = driver.findElement(By.id("info"));

	System.out.println(element.getText());
	assertTrue(element.getText().contains(error));

	//new WebDriverWait(driver, 60, 120);
	driver.close();
	//driver.quit();

    }
    
  /*  @Then("^the customer list is fetched$")
    public void the_customer_list_is_fetched() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }*/
    
   /* @AfterClass
    public void tearDown() {
	driver.quit();
    }*/

}
