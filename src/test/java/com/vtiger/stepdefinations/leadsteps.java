package com.vtiger.stepdefinations;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.util.List;

public class leadsteps extends basesteps
{



    @When("user click on new lead and fill the mandatory fields and click on save")
    public void user_click_on_new_lead_and_fill_the_mandatory_fields_and_click_on_save(io.cucumber.datatable.DataTable dataTable)
    {
        List<List<String>> lst  = dataTable.asLists();
        for (List<String> ls : lst)
        {
            driver.findElement(By.linkText("New Lead")).click();
            //driver.findElement(By.name("lastname")).sendKeys(ls.get(0));
            //driver.findElement(By.name("company")).sendKeys(ls.get(1));
            //driver.findElement(By.name("button")).click();
            ldp.createlead(ls.get(0),ls.get(1));
        }

    }

    @When("user click on new lead and fill the mandatory fields from excel and click on save")
    public void user_click_on_new_lead_and_fill_the_mandatory_fields_from_excel_and_click_on_save()
    {
            driver.findElement(By.linkText("New Lead")).click();
            //driver.findElement(By.name("lastname")).sendKeys(ls.get(0));
            //driver.findElement(By.name("company")).sendKeys(ls.get(1));
            //driver.findElement(By.name("button")).click();
            //ldp.createlead(ls.get(0),ls.get(1));

    }
    @When("click on logout")
    public void click_on_logout() {

        driver.findElement(By.linkText("Logout")).click();


    }
    @When("close browser")
    public void close_browser() {

        driver.quit();


    }
}
