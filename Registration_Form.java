package Test_case;

import Page_Obj_model.Base_page_obj;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Registration_Form {


    WebDriver driver;

    //Initialize the Chrome browser and open the application URL
    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximize browser
        driver.get("https://chulo-solutions.github.io/qa-internship/"); // open a website
    }


    //Navigate to Chulo Solution registartion form page and verify landing it.
    @Test public void landing_page() {
        Base_page_obj form_page= new Base_page_obj(driver);
        form_page.verify_Landing_page ();



    }

    //Verify user registration by submitting the form with valid data and success message
    @Test public void valid_data () {
        Base_page_obj input = new Base_page_obj(driver);
        input.enter_username("Anish12");
        input.enter_password("Anish@123");
        input.enter_credit_card("5185614589267185");
        input.enter_telephone_numb("(123) 456-7890");
        input.click_submit();
        input.verifyAlertText();


    }

    // Verify appropriate error messages are displayed to submit the form with invalid data for each field
    @Test public void invalid_data () {
        Base_page_obj invalid = new Base_page_obj(driver);
        invalid.enter_username("Anis@");
        invalid.enter_password("Anish");
        invalid.enter_credit_card("1234567890145627");
        invalid.enter_telephone_numb("9865777225");
        invalid.click_submit();
        invalid.verifyAlertTxt();



    }





    //Quit the browser and end the WebDriver session
    @AfterTest public void teardown() {
        driver.quit();
    }



}
