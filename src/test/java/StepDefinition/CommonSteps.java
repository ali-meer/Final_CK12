package StepDefinition;

import OR.loginOR;
import Util.Base;
import io.cucumber.java.en.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonSteps extends Base {
    private Base base;
    public CommonSteps (Base base){
        this.base = base;
    }
    File file;
    FileInputStream fis;
    Properties prop;
    loginOR login;



    @Given("ck12 is launched")
    public void ck12_is_launched() throws InterruptedException, IOException {

        file = new File(".\\src\\test\\resources\\Config\\prop.properties");
        fis = new FileInputStream(file);
        prop = new Properties();
        prop.load(fis);
        Thread.sleep(3000);

        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
        base.driver = new ChromeDriver();
        prop.getProperty(("browserName"),("baseURL"));

        login = new loginOR(base);

        Thread.sleep(1000);
        base.driver.manage().window().maximize();
        Thread.sleep(1000);
        base.driver.manage().deleteAllCookies();
        Thread.sleep(1000);
        base.driver.get(prop.getProperty("baseURL"));
        Thread.sleep(3000);
        //login.getToastCloseBtn();

    }

    @When("user clicks on SignIn button")
    public void user_clicks_on_sign_in_button() throws InterruptedException {

        login.SetSignInBtn();
    }

    @When("user enters username {string}")
    public void user_enters_username(String username) throws InterruptedException {

        login.SetUsernameTxt(username);

    }

    @When("user enter password {string}")
    public void user_enter_password(String password) throws InterruptedException {

        login.SetPasswordTxt(password);

    }

    @When("user clicks login button")
    public void user_clicks_login_button() throws InterruptedException {

        login.SetLoginSignInBtn();

    }

    @Then("SignIn should be {string}")
    public void sign_in_should_be(String Expected_Result) {

        login.expectedResult(Expected_Result);
        login.TearDown();

    }


}
