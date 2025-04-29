package com.vtiger.pages;

import com.vtiger.utilities.CommanMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.nio.file.WatchEvent;
import java.util.List;

public class leadpage extends CommanMethods

{
    private WebDriver driver;

    public leadpage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name='lastname']")
    WebElement tb_lastname;

    @FindBy(xpath = "//input[@name='company']")
    WebElement tb_company;

    @FindBy(name ="button")
    List<WebElement> btn_save;

    public void createlead(String lname, String comp)
    {
       setLastname(lname);
       setCompany(comp);
       clickSave();

    }

    public void setLastname(String lname)
    {
        setInput(tb_lastname,lname, lname+"has been entered lastname successfully");

    }

    public void setCompany(String comp)
    {
        setInput(tb_company, comp, comp+"has been entered company successfully");
    }

    public void clickSave()
    {
        clickElement(btn_save.get(1),"save button clicked");
    }



}
