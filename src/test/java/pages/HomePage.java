package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class HomePage {
    private By ContactUsLink = By.xpath("//span[text()='CONTACT US']");
//    private By TalkToExpert = By.xpath("//a[normalize-space()='Talk To Our Experts']");
    private By TalkToExpert = By.xpath("//*[@id=\"home-sec-one-new\"]/div[2]/div[1]/div/div[3]/div/a");

    public WebDriver driver;

    public WebDriver launchApplication(String appURL){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver =  new ChromeDriver(options);
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
