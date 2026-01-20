package Page_Obj_model;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


/**
 BasePageObj
 This class serves as the base for all Page Object classes.
 It provides reusable WebDriver utilities such as click, type,
 getText, and wait for elements.
 */


//constructor
public class Base_page_obj {

    WebDriver driver;
    WebDriverWait wait;

    public Base_page_obj(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }



    //locator of Chulo Solution registartion form landing page.
    By landing_page = By.xpath("/html/body/h2[1]");

    //Action and assertion of landing form page
    public void verify_Landing_page() {
        String ActualResult = driver.findElement(landing_page).getText();
        String expectedResult = "QA Internship Test Case Task";
        Assert.assertEquals(ActualResult,expectedResult);

    }


    // locator of user registration  data
    By username = By.xpath("//*[@id=\"username\"]");
    By password = By.xpath("//*[@id=\"password\"]");
    By credit_card = By.xpath("//*[@id=\"creditCard\"]");
    By telephone_numb = By.xpath("//*[@id=\"telephone\"]");
    By submit = By.xpath("//*[@id=\"validationForm\"]/button");



    //action and assertion of success message
    public void enter_username (String user_name){
        driver.findElement(username).sendKeys(user_name);
    }
    public void enter_password (String pass){
        driver.findElement(password).sendKeys(pass);
    }
    public void enter_credit_card (String credit){
        driver.findElement(credit_card).sendKeys(credit);
    }
    public void enter_telephone_numb (String numb){
        driver.findElement(telephone_numb).sendKeys(numb);
    }
    public void click_submit(){
        driver.findElement(submit).click();
    }

    //verifying alert success message
    public void verifyAlertText() {

        // Explicit wait AFTER submit button click
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        // Get alert text
        String alertText = alert.getText();

        // Assert the alert text
        Assert.assertEquals(alertText, "Form submitted successfully!");

        // Accept the alert
        alert.accept();
    }

    //verifying appropriate error messages
    public void verifyAlertTxt() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        Assert.assertEquals(alertText, "Username must be alphanumeric and between 5 to 15 characters.");
        alert.accept();

    }



















}
