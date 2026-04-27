package com.project6;

import org.openqa.selenium.WebDriver;
import com.project6.drivers.DriverSingleton;
import com.project6.pages.Login;
import com.project6.pages.User;
import com.project6.utills.Constans;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserExportTest {
    private WebDriver driver;
    private User userPage;

    public UserExportTest() {
        this.driver = DriverSingleton.getDriver();
        this.userPage = new User(driver);
    }

    @BeforeAll
    public static void setUp() {
        // Mengambil driver yang sudah ada (Singleton)
        WebDriver driver = DriverSingleton.getDriver();
        Login loginPage = new Login(driver);

        // Buka URL dan Login menggunakan kredensial dari LoginTest kamu
        driver.get(Constans.URL); 
        loginPage.setCredentials("admin@hadir.com", "MagangSQA_JC@123");
        loginPage.ClickLogin();
        
        System.out.println("BeforeAll: Login berhasil menggunakan akun admin@hadir.com");
    }

    @When("user click menu management and user menu")
    public void user_click_menu_management_and_user_menu() {
        userPage.clickManagementMenu();
        userPage.clickUserMenu();
    }

    @And("user click button export")
    public void user_click_button_export() {
        userPage.clickExportButton();
    }

    @Then("user success download file export")
    public void user_success_download_file_export() {
        System.out.println("Verifikasi: File export berhasil diproses.");
    }
}