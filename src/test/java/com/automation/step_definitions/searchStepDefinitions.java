package com.automation.step_definitions;

import com.automation.pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class searchStepDefinitions {

    SearchPage searchPage=Hooks.homepage.SearchPage1();
    @When("user clicks on search field")
    public void user_clicks_on_search_field()
    {
        searchPage.Search();
    }

    @And("user search with name of product")
    public void user_search_with_name_of_product()
    {
        //Hooks.driver.findElement(By.id("small-searchterms")).sendKeys("book");
        //Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 search-box-button\"]")).click();
        searchPage.SearchBtn("book");

    }

    @Then("user could find relative results")
    public void user_could_find_relative_results()
    {
        int count = Hooks.driver.findElements(By.cssSelector("h2[class=\"product-title\"] a")).size();  // 0
        System.out.println(count);
        Assert.assertTrue(count > 0);

        // findelements     [webelement0, webelement1]
        for (int x = 0; x < count ; x++) {
            System.out.println("sara---------------"+Hooks.driver.findElements(By.cssSelector("h2[class=\"product-title\"] a")).get(x).getText());
            Assert.assertTrue(Hooks.driver.findElements(By.cssSelector("h2[class=\"product-title\"] a")).get(x).getText().toLowerCase().contains("book"));
        }
    }

}
