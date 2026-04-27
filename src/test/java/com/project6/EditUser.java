package com.project6;

import org.openqa.selenium.WebDriver;
import com.project6.drivers.DriverSingleton;
import com.project6.pages.User;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditUser {
    private WebDriver driver;
    private User userPage;

    public EditUser() {
        this.driver = DriverSingleton.getDriver();
        this.userPage = new User(driver);
    }

    // Catatan: Jika langkah "click menu management" sudah ada di UserExportTest, 
    // jangan tulis lagi di sini supaya tidak DuplicateStepDefinitionException.

    @When("user click titik tiga menu")
        public void user_click_titik_tiga_menu() {
        userPage.clickTitikMenu();
}

    @And("user click edit menu")
        public void user_click_edit_menu() {
        userPage.clickEditMenu();
}

    @Then("user mengosongkan field NIK")
        public void user_mengosongkan_field_nik() {
        userPage.clearFieldNIK();
}

    @And("user click button save")
        public void user_click_button_submit() {
        userPage.clickSaveEditMenu();
}

}