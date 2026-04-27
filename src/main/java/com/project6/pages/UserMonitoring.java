package com.project6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserMonitoring {
    public UserMonitoring (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//p[contains(text(), 'User Monitoring')]")
    private WebElement userMonitoringMenu;

    @FindBy (xpath = "//input[@id='fullname']")
    private WebElement fieldFullName;

    @FindBy (xpath = "//input[@id='email']")    
    private WebElement fieldEmail;

    @FindBy (xpath = "//input[@id='password']")
    private WebElement fieldPassword;

    @FindBy (xpath = "//input[@id='free-solo-with-text-demo']")
    private WebElement fieldFreeSoloWithTextDemo;

    @FindBy (xpath= "//button[normalize-space()='Tambah']")
    private WebElement submitAddUserButton;

    public void clickUserMonitoringMenu() {
        userMonitoringMenu.click();
    }
    
    public void setFieldFullName(String fullName) {
        fieldFullName.sendKeys(fullName);
    }
    public void setFieldEmail(String email) {
        fieldEmail.sendKeys(email);
    }
    public void setFieldPassword(String password) {
        fieldPassword.sendKeys(password);
    }
    public void setFieldFreeSoloWithTextDemo(String freeSoloWithTextDemo) {
        fieldFreeSoloWithTextDemo.sendKeys(freeSoloWithTextDemo);
    }
    public void clickSubmitAddUserButton() {
        submitAddUserButton.click();
    }

    public void addUserMonitoring(String fullName, String email, String password, String freeSoloWithTextDemo) {
        clickUserMonitoringMenu();
        setFieldFullName(fullName);
        setFieldEmail(email);
        setFieldPassword(password);
        setFieldFreeSoloWithTextDemo(freeSoloWithTextDemo);
        clickSubmitAddUserButton();
    }
}