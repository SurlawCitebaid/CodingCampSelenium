package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Planet {
    WebElement planetElement;


    public Planet(WebElement planetElement){
        this.planetElement = planetElement;
    }

    public String getName(){
        return planetElement.findElement(By.tagName("h2")).getText();
    }

//    public String getDistFromTheSun(){
//        return planetElement.findElement(By.className("distance")).getText();
//    }

    public String  getDistFromTheSun(){
        return planetElement.findElement(By.className("distance")).getText();
    }

    public String getRadius(){
        return planetElement.findElement(By.className("radius")).getText();
    }

    public void clickExploreButton(){
        planetElement.findElement(By.tagName("button")).click();
    }

    //Name
    //Distance from the sun
    //Radius
    //ExploreButton
    //ClickExploreButton()
}
