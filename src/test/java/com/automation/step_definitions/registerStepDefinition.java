package com.automation.step_definitions;

import com.automation.pages.LoginPage;
import com.automation.pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class registerStepDefinition {

    private  String fristname="sara";
    private String lastname="elsayed";
    public static String usernEmail="saraelsayed5@gmail.com";
    public static String password="p@ssw0rd5";
    RegisterPage registerPage;


    @Given("user go to register page")
    public void user_go_to_register_page() {
        registerPage=Hooks.homepage.redirectedToregisterPage();

    }
    @When("user lregister with valid fristname and lastname and email and password and confirmPassword")
    public void user_lregister_with_valid_fristname_and_lastname_and_email_and_password_and_confirm_password() {
        registerPage.registerNewUser(fristname,lastname,usernEmail,password);

    }
    @And("user press on register button")
    public void user_press_on_register_button() {
        registerPage.clickBtnregister();
    }
    @Then("user register to the system successfully")
    public void user_register_to_the_system_successfully() {
        Assert.assertEquals(registerPage.resulteRegister(), "Your registration completed");
        System.out.println("sara----------------"+registerPage.resulteRegister());
    }
    @And("user logout to login page")
    public void user_logout_to_login_page() {
        registerPage.logOutUser();
    }

}
