package com.vtiger.pages;

import com.vtiger.utilities.CommanMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginpage extends CommanMethods {

    private WebDriver driver;

    public loginpage(WebDriver driver)

    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name="user_name")
    WebElement tb_uid;

    @FindBy(name="user_password")
    WebElement tb_pass;

    @FindBy(name="Login")
    WebElement btn_login;

    public void login(String userid, String pwd)
    {
        setUsername(userid);
        setPassword(pwd);
        clickLogin();
    }

    public void setUsername(String userid)
    {
        setInput(tb_uid, userid, userid+"has been entered into username field");

    }

    public void setPassword(String pwd)
    {
       setInput(tb_pass,pwd,pwd+"has been entered into password filed");
    }

    public void clickLogin()
    {
        clickElement(btn_login,"Login button clicked");
    }











}
