package com.automation.step_definitions;

import com.automation.pages.LoginPage;
import com.automation.pages.LoginPageBeforeSearch;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class loginStepDefinitions {
    LoginPage loginPage;
    @Given("user go to login page")
    public void go_to_login_page()  {
        loginPage =Hooks.homepage.loginPage1();
       }


    @When("user login with valid email and password")
    public void valid_username_password()
    {
        String email= registerStepDefinition.usernEmail;
        String password=registerStepDefinition.password;
        loginPage.UserLogin(email,password);

    }


    @Then("user login to the system successfully")
    public void success_login()
    {
        Assert.assertEquals(loginPage.GetMyAccount(),"My account","Login successful");
        System.out.println("sara----------------"+loginPage.GetMyAccount());
        loginPage.logOutUser();
    }

}
