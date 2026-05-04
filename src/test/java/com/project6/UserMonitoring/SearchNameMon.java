package com.project6.UserMonitoring;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import com.project6.drivers.DriverSingleton;
import com.project6.pages.UserMonitoring;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en_scouse.An;

import org.testng.Assert;

public class SearchNameMon {

    private WebDriver driver;
    private UserMonitoring userMonitoringPage;
    private WebDriverWait wait;

    public SearchNameMon() {
        this.driver = DriverSingleton.getDriver();
        this.userMonitoringPage = new UserMonitoring(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    // ✅ validasi search (monitoring)
    @Then("user should see search monitoring result with name {string}")
    public void user_should_see_search_monitoring_result_with_name(String expectedName) {
        String actualName = userMonitoringPage.getFirstResultName();
        Assert.assertEquals(actualName, expectedName, "Nama yang ditampilkan tidak sesuai dengan yang dicari.");        
    
    }

    // ✅ reset search (monitoring)
    @And("user click button reset monitoring")
    public void user_click_button_reset_monitoring() {
        userMonitoringPage.clickResetButtonMonitoring();
    }

}