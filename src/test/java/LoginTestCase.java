/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author yehezikha.beatrix
 */
public class LoginTestCase {
    
    WebDriver driver = null;
    

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }
    
    @Test
    public void testCase1(){
        driver.get("http://pluto18.epizy.com/");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin123");
        driver.findElement(By.xpath("/html/body/div/form/input[3]")).click();
        String expectedTitle = "true";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    
    @Test
    public void testCase2(){
        driver.get("http://pluto18.epizy.com/");
        driver.findElement(By.id("username")).sendKeys("admin1");
        driver.findElement(By.id("password")).sendKeys("admin123");
        driver.findElement(By.xpath("/html/body/div/form/input[3]")).click();
        String expectedTitle = "Wrong username or password!";
        String actualTitle = driver.findElement(By.className("notif")).getText();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testCase3(){
        driver.get("http://pluto18.epizy.com/");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin1123");
        driver.findElement(By.xpath("/html/body/div/form/input[3]")).click();
        String expectedTitle = "Wrong username or password!";
        String actualTitle = driver.findElement(By.className("notif")).getText();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    
    
    @Test
    public void testCase4(){
        driver.get("http://pluto18.epizy.com/");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.xpath("/html/body/div/form/input[3]")).click();
        String expectedTitle = "true";
        String actualTitle = driver.findElement(By.id("password")).getAttribute("required");
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testCase5(){
        driver.get("http://pluto18.epizy.com/");
        driver.findElement(By.id("password")).sendKeys("admin123");
        driver.findElement(By.xpath("/html/body/div/form/input[3]")).click();
        String expectedTitle = "true";
        String actualTitle = driver.findElement(By.id("username")).getAttribute("required");
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    
    
    @Test
    public void testCase6(){
        driver.get("http://pluto18.epizy.com/");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin1234");
        String expectedTitle = "password";
        String actualTitle = driver.findElement(By.id("password")).getAttribute("type");
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    


    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
