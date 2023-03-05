package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HomePage {
    private By ContactUsLink = By.xpath("//span[text()='CONTACT US']");

    public WebDriver driver;

    public WebDriver launchApplication(String appURL){
        WebDriverManager.chromedriver().setup();
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(appURL);
        return driver;
    }

    public void clickOnContactUsLink(WebDriver driver) {
        driver.findElement(ContactUsLink).click();
    }

}
