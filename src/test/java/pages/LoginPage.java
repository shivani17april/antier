package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage  {
    public WebDriver driver;

    private By userNameField= By.id("email");
    private By passwordField = By.id("pass");
    private By ContactUsLink = By.xpath("//span[contains(text(),'CONTACT US')]");


    public void userLaunchWebApplication(String appURL) {
        WebDriverManager.chromedriver().setup();
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(appURL);
    }

    public void submitUserName(String username) {
        driver.findElement(userNameField).sendKeys(username);
    }

    public void submitPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickOnContactUsLink() {
        driver.findElement(ContactUsLink).click();
    }


}
