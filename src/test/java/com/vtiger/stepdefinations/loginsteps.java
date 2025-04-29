package com.vtiger.stepdefinations;

import com.vtiger.pages.leadpage;
import com.vtiger.pages.loginpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class loginsteps extends basesteps
{


    @Given("user should be on login")
    public void user_should_be_on_login() throws Exception {
        launchApp();



    }
    @When("user enters valid credentials")
    public void user_enters_valid_credentials()
    {

       // driver.findElement(By.name("user_name")).sendKeys("admin");
        //driver.findElement(By.name("user_password")).sendKeys("admin");
       // lp.login("admin","admin");
        //lp.setUsername("admin");
        //lp.setPassword("admin");

        lp.setUsername(prop.getProperty("userid"));
        lp.setPassword(prop.getProperty("password"));


    }
    @When("click login button")
    public void click_login_button()
    {
        driver.findElement(By.name("Login")).click();
      //lp.clickLogin();
    }
    @Then("user should be on navigated to home page")
    public void user_should_be_on_navigated_to_home_page()
    {
        driver.findElement(By.linkText("Home")).isDisplayed();

    }
    @Then("user can see the logout link")
    public void user_can_see_the_logout_link()
    {
        driver.findElement(By.linkText("Logout")).isDisplayed();

    }

    @When("user enters invalid credentials")
    public void user_enters_invalid_credentials()
    {

        //driver.findElement(By.name("user_name")).sendKeys("admin12");
        //driver.findElement(By.name("user_password")).sendKeys("admin");

        //lp.login("admin12","admin12");
        lp.setUsername("admin12");
        lp.setPassword("admin12");

    }

    @When("user login successfully")
    public void user_login_successfully()
    {

        //driver.findElement(By.name("user_name")).sendKeys("admin12");
        //driver.findElement(By.name("user_password")).sendKeys("admin");

      lp.login("admin","admin");


    }

    @Then("user should ne navigated to login page")
    public void user_should_ne_navigated_to_login_page()
    {
       //driver.findElement(By.name("user_name")).isDisplayed();

    }

    @Then("user can see the error message")
    public void user_can_see_the_error_message()
    {
        driver.findElement(By.xpath("//*[contains(text(),'You must specify a valid username and password.')]")).isDisplayed();

    }

    @When("user enters invalid credentials username as {string} and password as {string}")
    public void user_enters_invalid_credentials_username_as_and_password_as(String uid, String pwd)
    {
       // driver.findElement(By.name("user_name")).sendKeys(uid);
        //driver.findElement(By.name("user_password")).sendKeys(pwd);
       // lp.login(uid, pwd);
        lp.setUsername(uid);
        lp.setPassword(pwd);
    }







}
