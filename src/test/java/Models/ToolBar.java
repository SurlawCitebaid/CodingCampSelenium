package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ToolBar {

    WebDriver driver;
    public ToolBar(WebDriver driver){
        this.driver = driver;
    }

    public void clickByButtonName(String name){
        driver.findElement(By.cssSelector("a[aria-label="+name+"]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.urlToBe("https://d18u5zoaatmpxx.cloudfront.net/#/" + name));
    }
}
