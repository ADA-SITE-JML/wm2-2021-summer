package ada.wm2.tst.selenium.controller;

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

class StudentControllerTest {

    @Test
    public void testNewUserSuccess() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/student/new");

        driver.findElement(By.id("firstName")).sendKeys("Aygul");
        driver.findElement(By.id("lastName")).sendKeys("Bayramova");
        driver.findElement(By.id("email")).sendKeys("ah@ada.edu.az");
        driver.findElement(By.id("school")).sendKeys("SPIA");
        driver.findElement(By.id("submit")).click();

        String bodyText = driver.findElement(By.tagName("body")).getText();
        assertThat(bodyText.contains("Aygul"));
        assertThat(bodyText.contains("ah@ada.edu.az"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }

}