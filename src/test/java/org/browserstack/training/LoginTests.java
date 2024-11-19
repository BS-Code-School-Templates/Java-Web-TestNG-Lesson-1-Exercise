package org.browserstack.training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class LoginTests {
    String correctUsername = "student";
    String correctPassword = "Password123";
    String wrongUsername = "wrongstudent";
    String wrongPassword = "Password456";

    String successMessage = "Login successful!";
    String incorrectUsernameMessage = "Incorrect username!";
    String incorrectPasswordMessage = "Incorrect password!";
    String incorrectUserAndPassMessage = "Incorrect username and password!";

    @Test
    public void successfulLoginTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("http://browserstacktraining.site");
            driver.manage().window().maximize();

            driver.findElement(By.cssSelector("#loginButton")).click();

            driver.findElement(By.cssSelector("#username")).sendKeys(correctUsername);
            driver.findElement(By.cssSelector("#password")).sendKeys(correctPassword);
            driver.findElement(By.cssSelector("#submit")).click();

            assert driver.findElement(By.id("message")).getText().equals(successMessage);
            driver.quit();
        } catch (Exception e) {
            driver.quit();
            System.out.println("There was an error: " + e);
        }


    }

    @Test
    public void failedLoginTestUsername() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("http://browserstacktraining.site");
            driver.manage().window().maximize();

            driver.findElement(By.cssSelector("#loginButton")).click();

            driver.findElement(By.cssSelector("#username")).sendKeys(wrongUsername);
            driver.findElement(By.cssSelector("#password")).sendKeys(correctPassword);
            driver.findElement(By.cssSelector("#submit")).click();

            assert driver.findElement(By.id("message")).getText().equals(incorrectUsernameMessage);
            driver.quit();
        } catch (Exception e) {
            driver.quit();
            System.out.println("There was an error: " + e);
        }


    }

    @Test
    public void failedLoginTestPassword() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("http://browserstacktraining.site");
            driver.manage().window().maximize();

            driver.findElement(By.cssSelector("#loginButton")).click();

            driver.findElement(By.cssSelector("#username")).sendKeys(correctUsername);
            driver.findElement(By.cssSelector("#password")).sendKeys(wrongPassword);
            driver.findElement(By.cssSelector("#submit")).click();

            assert driver.findElement(By.id("message")).getText().equals(incorrectPasswordMessage);
            driver.quit();
        } catch (Exception e) {
            driver.quit();
            System.out.println("There was an error: " + e);
        }
    }

    @Test
    public void failedLoginTestUsernameAndPassword() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("http://browserstacktraining.site");
            driver.manage().window().maximize();

            driver.findElement(By.cssSelector("#loginButton")).click();

            driver.findElement(By.cssSelector("#username")).sendKeys(wrongUsername);
            driver.findElement(By.cssSelector("#password")).sendKeys(wrongPassword);
            driver.findElement(By.cssSelector("#submit")).click();

            assert driver.findElement(By.id("message")).getText().equals(incorrectUserAndPassMessage);
            driver.quit();
        } catch (Exception e) {
            driver.quit();
            System.out.println("There was an error: " + e);
        }
    }
}
