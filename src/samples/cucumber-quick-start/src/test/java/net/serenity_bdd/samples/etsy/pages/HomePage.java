package net.serenity_bdd.samples.etsy.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

// tag::header[]
@DefaultUrl("http://www.etsy.com")                      // <1>
public class HomePage extends PageObject {              // <2>
// end::header[]
// tag::searchByKeyword[]

    @FindBy(css = "button[value='Search']")
    WebElement searchButton;

    public void searchFor(String keywords) {
        $("#search-query").sendKeys(keywords);          // <3>
        searchButton.click();                           // <4>
    }

    public void dismissLocationMessage() {
        if (!findAll(By.cssSelector("input[value='Okay']")).isEmpty()) {
            find(By.cssSelector("input[value='Okay']")).click();
        }
        waitForAbsenceOf("Your preferences have been saved");
    }
// end::searchByKeyword[]
// tag::tail[]
}
// end::tail[]