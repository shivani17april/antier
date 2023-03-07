package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import sendEmail.SendEmail;

import java.util.concurrent.TimeUnit;

public class TalkToExpertsPage {
    By nameField = By.name("text-800");
    By emailField = By.name("email-65");
    //By phoneField = By.name("tel-147");
    By phoneField = By.xpath("//input[@placeholder='Phone Number*']");
    By msgField = By.name("textarea-662");
    //    By sub = By.xpath("//div[@class='f-block rg']//input[@value='Submit']");
//    By sub = By.className("wpcf7-form-control has-spinner wpcf7-submit");

    By sub = By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[7]/div[1]/p[1]/input[1]");
    By countryIcon = By.xpath("//*[@id=\"wpcf7-f1917-o1\"]/form/div[2]/div[3]/div/p/span/div/div");
    //*[@id="wpcf7-f1917-o1"]/form/div[2]/div[3]/div/p/span/div/div

//    public String isContactUsTitleAvailable(WebDriver driver) {
//        return driver.getTitle();
//    }

    public void enterName(WebDriver driver, String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterEmail(WebDriver driver, String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPhone(WebDriver driver, String email) {
        driver.findElement(phoneField).sendKeys(email);
    }

    public void enterMsg(WebDriver driver, String msg) {
        driver.findElement(msgField).sendKeys(msg);
    }

    public void enterCountry(WebDriver driver, String countryCode, String country_name) {
        driver.findElement(countryIcon).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //(//span[@class='country-name'])[401])
        //(//div[@class='selected-flag'])[3]
        //*[@id="wpcf7-f1917-o1"]/form/div[2]/div[3]/div/p/span/div/div/ul/li[7]
        ////ul[@class='country-list']//span[@class='country-name'][normalize-space()='Albania (Shqipëri)']
//        By countryName = By.xpath("//li[@data-country-code='"
//                + countryCode + "']/span[contains(text(),'"
//                + country_name + "')]");
        try {
            By countryName = By.xpath("(//span[@class='country-name'])[402]");
            driver.findElement(countryName).click();
        } catch (Exception e) {
            System.out.println("TAG...." + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void clickOnContactSubmit(WebDriver driver) {
        SendEmail email = new SendEmail();
        email.sendEmailFxn("hellos", "test email");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //driver.findElement(sub).click();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(sub)).click().perform();
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
