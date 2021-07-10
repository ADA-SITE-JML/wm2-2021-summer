package ada.wm2.carrental.selenium;

import org.apache.tomcat.jni.Time;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.lang.Thread.sleep;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class AuthenticationControllerTest
{

    @Test
    public void testLogin()
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/auth/");
        driver.findElement(By.id("email")).sendKeys("nuray@mail.com");
        driver.findElement(By.id("password")).sendKeys("123123123");
        driver.findElement(By.cssSelector("input[type=\"submit\"")).click();

        String bodyText = driver.findElement(By.tagName("body")).getText();
        assertThat(bodyText.contains("Car Rental Website"));

        try
        {
            Thread.sleep(1500);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        driver.close();
    }

    @Test
    public void testRegister()
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/auth/register");
        driver.findElement(By.id("name")).sendKeys("nuray leysanli");
        driver.findElement(By.id("email")).sendKeys("nuray@mail.ru");
        driver.findElement(By.id("password")).sendKeys("321321321");
        driver.findElement(By.cssSelector("input[type=\"submit\"")).click();

        String bodyText = driver.findElement(By.tagName("body")).getText();
        assertThat(bodyText.contains("Log in"));

        try
        {
            Thread.sleep(3000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        driver.close();
    }
}
