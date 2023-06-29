package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PlanetPage {

    WebDriver driver;
    public PlanetPage(WebDriver driver){
        this.driver = driver;
    }

    public ArrayList<Planet> getAllPlanets(){
        List<WebElement> planetElements = driver.findElements(By.cssSelector(".planet"));
        ArrayList<Planet> planets = new ArrayList<Planet>();

        for(WebElement planetElement : planetElements){
            planets.add(new Planet(planetElement));
        }
        return planets;
    }

    public Planet getPlanetByName(String name, ArrayList<Planet> planets){
        for(Planet planet: planets){
            if(planet.getName().equals(name)){
                return planet;
            }
        }
        return null;
    }
}
