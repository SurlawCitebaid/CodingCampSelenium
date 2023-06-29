package Test;

import Models.Form;
import Models.Planet;
import Models.PlanetPage;
import Models.ToolBar;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class SeleniumTest {
    private WebDriver driver;


    @BeforeEach
    public void openBrowserAndSetDriver(){
        setDriver();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/");
    }

    @Test
    public void SendKeysToForenameFieldTest(){
        driver.findElement(By.id("forename")).sendKeys("Yeah boi");
    }

    @Test
    public void ClickSubmitButtonTest(){
        driver.findElement(By.id("submit")).click();
    }

    @Test
    public void DoesTheTitelMatchWeb(){
        String textInH1 = driver.findElement(By.tagName("H1")).getText();
        Assertions.assertEquals("Web Playground", textInH1);

    }

    @Test
    public void ClickButtonUpTest(){
          //Arrange

          //Act - Click the button the says CLICK ME DOWN!
          driver.findElement(By.cssSelector("[role=button]")).click();

          //Assert - Wait for the button to be clicked and then make sure the text has changed first before doing the assert
          new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.textToBe(By.cssSelector( ".transition-y"), "CLICK ME UP!"));

          String elementText = driver.findElement(By.cssSelector(".transition-y")).getText();
          Assertions.assertEquals("CLICK ME UP!", elementText);
    }

    @Test
    public void ClickButtonDownTest(){
        //Arrange
        driver.findElement(By.cssSelector("[role=button]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.textToBe(By.cssSelector( ".transition-y"), "CLICK ME UP!"));

        //Act
        driver.findElement(By.cssSelector(".transition-y")).click();
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.textToBe(By.cssSelector( "[role=button]"), "CLICK ME DOWN!"));


        //Assert
        Assertions.assertEquals("CLICK ME DOWN!", driver.findElement(By.cssSelector("[role=button]")).getText());
    }

    @Test
    public void ClickandSubmitFormTest(){

        //Arrange
        new ToolBar(driver).clickByButtonName("forms");

        //Act
        Form form = new Form(driver);
        form.enterName("James Logan");
        form.enterEmail("someone@gmail.com");
        form.selectState("NSW");
        form.clickAgree();
        form.clickSubmit();

        //Assert
        Assertions.assertEquals("Thanks for your feedback James Logan",driver.findElement(By.cssSelector("div.popup-message")).getText());
    }

    @Test
    public void findAPlanetByNameTest(){
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/planets");
        PlanetPage planetPage = new PlanetPage(driver);

        ArrayList<Planet> planets = planetPage.getAllPlanets();
        Planet earth  = planetPage.getPlanetByName("Earth",planets);

        System.out.println(earth.getName());
        System.out.println(earth.getRadius());
        System.out.println(earth.getDistFromTheSun());
    }

    @Test
    public void clickPlanetExploreButton(){
        new ToolBar(driver).clickByButtonName("planets");
        PlanetPage planetPage = new PlanetPage(driver);
        ArrayList<Planet> planets = planetPage.getAllPlanets();
        planetPage.getPlanetByName("Earth", planets).clickExploreButton();
    }

    @Test
    public void findPlanetByDistance(){
        new ToolBar(driver).clickByButtonName("planets");
        PlanetPage planetPage = new PlanetPage(driver);
        ArrayList<Planet> planets = planetPage.getAllPlanets();

        for(Planet planet : planets){
            if(planet.getDistFromTheSun().equals("2,871,000,000 km")){
                System.out.println(planet.getName());
                Assertions.assertEquals("2,871,000,000 km",planet.getDistFromTheSun());
                return;
            }
        }
        throw new NotFoundException("Planet was not found");
    }

    @AfterEach
    public void quitDriver(){
        driver.quit();
    }

    private void setDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }



    //Test format
    //Arrange
    //Act
    //Assert


//    @Test
//    public void AllTests(){
//
//
//        driver.findElement(By.id("forename")).sendKeys("Yeah boi");
//        driver.findElement(By.id("submit")).click();
//        String textInH1 = driver.findElement(By.tagName("H1")).getText();
//        Assertions.assertEquals("Web Playground", textInH1);
//
//        //driver.findElement(By.xpath("/html/body/div/div[1]/main/div/div/div[3]/div[2]/div[2]/a")).click();
//        driver.findElement(By.linkText("CLICK ME DOWN!")).click();
//        driver.findElement(By.linkText("CLICK ME UP!")).click();
//        //driver.findElement(By.xpath("/html/body/div/div[1]/main/div/div/div[3]/div[2]/div[2]/a")).click();
//    }

}
