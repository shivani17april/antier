package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {
    By nameField = By.name("your-name");
    By countryIcon = By.xpath("//div[@class='flag-dropdown']");

    public String isContactUsTitleAvailable(WebDriver driver) {
       return driver.getTitle();
    }

    public void enterName(WebDriver driver,String name){
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterCountry(WebDriver driver,String countryCode,String country_name){
        driver.findElement(countryIcon).click();
        By countryName= By.xpath("//li[@data-country-code='"+countryCode+"']/span[contains(text(),'"+country_name+"')]");
        driver.findElement(countryName).click();
    }
}
