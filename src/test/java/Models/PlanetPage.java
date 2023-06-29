package Models;

import Strategies.MatchingStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PlanetPage {

    WebDriver driver;
    ArrayList<Planet> planets;
    public PlanetPage(WebDriver driver){
        this.driver = driver;
        planets = getAllPlanets();
    }

    public ArrayList<Planet> getAllPlanets(){
        List<WebElement> planetElements = driver.findElements(By.cssSelector(".planet"));
        ArrayList<Planet> planets = new ArrayList<Planet>();

        for(WebElement planetElement : planetElements){
            planets.add(new Planet(planetElement));
        }
        return planets;
    }

    public Planet getPlanet(Predicate<Planet> strategy){
        for(Planet planet: planets){
            if(strategy.test(planet)){
                return planet;
            }
        }
        return null;
    }

}
