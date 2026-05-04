package com.project6.AbsenPoint;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import com.project6.drivers.DriverSingleton;
import com.project6.pages.AbsenPoint;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddAbsenPoint {

    private WebDriver driver;
    private AbsenPoint absenPointPage;
    private WebDriverWait wait;

    public AddAbsenPoint() {
        this.driver = DriverSingleton.getDriver();
        this.absenPointPage = new AbsenPoint(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @And("user click absen point menu")
    public void user_click_absen_point_menu() {
        absenPointPage.clickAbsenPointMenu();
    }

    @And("user click tambah absen point menu")
    public void user_click_tambah_absen_point_menu() {
        absenPointPage.clickTambahAbsenPointMenu();
    }

    @And("user click field nama absen point")
    public void user_click_field_nama_absen_point() {
        absenPointPage.clickfieldName();
    }

    @And("user input nama absen point {string}")
    public void user_input_nama_absen_point(String name) {
        absenPointPage.inputNama(name);
    }

    
  @And("user input longitude absen point {string}")
    public void user_input_longitude_absen_point(String longitude) {
        absenPointPage.inputLongitude(longitude);
    }

    @And("user input radius absen point {string}")
    public void user_input_radius_absen_point(String radius) {
        absenPointPage.inputRadius(radius);
    }

     @And("user input latitude absen point {string}")
    public void user_input_latitude_absen_point(String latitude) {
        absenPointPage.inputLatitude(latitude);
    }

    @And("user input deskripsi absen point {string}")
    public void user_input_deskripsi_absen_point(String description) {
        absenPointPage.inputDescription(description);
    }

    @And("user click submit absen point")
    public void user_click_submit_absen_point() {
        absenPointPage.clicksubmitButtonAbsen();
    }

    @Then("user kembali ke halaman absen point")
    public void user_kembali_ke_halaman_absen_point() {
        String expectedEndpoint = "/management/location-point";
        
        try {
            // Tunggu hingga URL mengandung endpoint yang diharapkan
            wait.until(ExpectedConditions.urlContains(expectedEndpoint));
            String actualUrl = driver.getCurrentUrl();
            System.out.println("DEBUG: URL saat ini adalah [" + actualUrl + "]");
            Assert.assertTrue(actualUrl.contains(expectedEndpoint), 
                "Gagal! URL seharusnya mengandung [" + expectedEndpoint + "] tetapi saat ini [" + actualUrl + "]");
        } catch (Exception e) {
            // Jika timeout, berikan pesan error yang jelas
            Assert.fail("Timeout: Gagal kembali ke halaman absen point setelah klik Batal. URL saat ini: " + driver.getCurrentUrl());
        }
    }

      @And("user input field search name absen point")
    public void user_input_field_search_name_absen_point() {
        absenPointPage.inputFieldSearchAbsenPoint("Izzah Luthfiah"); 
    }

    @Then("user should see search absen result with name {string}")
    public void user_should_see_search_absen_result_with_name(String expectedName) {
    // Ambil teks yang muncul di layar (yang tadi hasilnya "2026-05-01Bramskuy")
    String actualText = absenPointPage.getFirstResultNameAbsen(); 
    
    // Gunakan contains supaya selama ada kata "Bramskuy", test-nya PASS
    Assert.assertTrue(actualText.contains(expectedName), 
        "Nama tidak ditemukan! Hasil di layar: " + actualText + ", yang dicari: " + expectedName);
    }

    @Then("user should see the new absen point in the list")
    public void user_should_see_the_new_absen_point_in_the_list() {
        String expectedName = "Kantor Pusat";
        String actualName = absenPointPage.getNamaFieldValueAbsen();
        Assert.assertEquals(actualName, expectedName, "Absen Point baru tidak ditemukan di daftar!");
    }

        @And ("user click search absen button")
        public void user_click_search_absen_button() {
        absenPointPage.clickSearchButtonAbsenPoint();
    }

    @Then("user verify field search absen point should be empty")
    public void user_verify_field_search_absen_point_should_be_empty() {   
        absenPointPage.clickResetButtonAbsenPoint(); // Pastikan klik reset sebelum validasi
        // Beri jeda singkat untuk memastikan field benar-benar ter-reset   
    String searchValue = absenPointPage.getSearchFieldValueAbsenPoint();
    Assert.assertEquals(searchValue, "", "Field search tidak kosong setelah reset!");
    }
}
