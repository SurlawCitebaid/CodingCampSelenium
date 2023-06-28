package Models;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Form {
    WebDriver driver;
    public Form(WebDriver driver){
        this.driver = driver;
    }
    public void enterName(String name) {
        driver.findElement(By.id("name")).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    public void selectState(String stateName) {
        driver.findElement(By.cssSelector("div.v-select__selections")).click();
        List<WebElement> listBoxOptions = driver.findElements(By.cssSelector("div.v-list-item__title"));

        for(WebElement option : listBoxOptions){

            if(option.getText().equals(stateName)){
                option.click();
                return;
            }
        }
    }

    public void clickAgree() {
        driver.findElement(By.cssSelector("[for=agree]")).click();
    }

    public void clickSubmit(){
        for(WebElement button : driver.findElements(By.cssSelector("[type=button]"))){
            if(button.getText().equalsIgnoreCase("submit")){
                button.click();
                break;
            }
        }

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.textToBe(By.cssSelector("div.popup-message"),"Thanks for your feedback James Logan"));
    }
}
