package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class HomePage {
    private By ContactUsLink = By.xpath("//span[text()='CONTACT US']");
    private By TalkToExpert = By.xpath("//a[normalize-space()='Talk To Our Experts']");

    public WebDriver driver;

    public WebDriver launchApplication(String appURL) {
        WebDriverManager.chromedriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(appURL);
        return driver;
    }

    public void talktoExp(WebDriver driver) {
        driver.findElement(TalkToExpert).click();
    }

    public void clickOnContactUsLink(WebDriver driver) {
        driver.findElement(ContactUsLink).click();
    }

}
