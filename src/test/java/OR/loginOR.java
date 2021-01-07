package OR;


import Util.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class loginOR extends Base {
    private Base base;

    public loginOR(Base base) {
        this.base = base;
    }
    By SignInBtn = By.xpath("//ul/li/a/span[contains(text(),'sign in')]");
    By usernameTxt = By.xpath("//input[@name='login']");
    By passwordTxt = By.xpath("//input[@name='token']");
    By loginSignInBtn = By.xpath("//input[@value='Sign In']");
    By toastCloseBtn = By.xpath("//div[@id='toast-close-button']");


    public void SetSignInBtn() throws InterruptedException {
        base.driver.findElement(SignInBtn).click();
        Thread.sleep(1000);
    }

    public void SetUsernameTxt(String username) throws InterruptedException {
        base.driver.findElement(usernameTxt).sendKeys(username);
        Thread.sleep(1000);
    }

    public void SetPasswordTxt(String password) throws InterruptedException {
        base.driver.findElement(passwordTxt).sendKeys(password);
        Thread.sleep(1000);
    }

    public void SetLoginSignInBtn() throws InterruptedException {
        base.driver.findElement(loginSignInBtn).click();
        Thread.sleep(1000);
    }

    public void expectedResult(String Expected_Result){
        String title = base.driver.getTitle();
        System.out.println(title);

        if(title.equalsIgnoreCase("Welcome to CK-12 Foundation | CK-12 Foundation")){
            System.out.println(Expected_Result);
        }else
        {
            System.out.println("Failed");
        }
    }

    public void getToastCloseBtn() throws InterruptedException {
        WebElement toastClose = base.driver.findElement(toastCloseBtn);
        if(toastClose.isDisplayed()){
            Thread.sleep(3000);
            toastClose.click();
        }else
        {
            System.out.println("No Toast Close Button is Displayed.");
        }
    }


    public void TearDown(){
    base.driver.close();
    }
}
