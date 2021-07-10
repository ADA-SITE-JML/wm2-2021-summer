package ada.wm2.bookauthor.selenium.controller;

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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class HomeControllerTest {

//    @Test
//    public void testAddNewAuthor() {
//
//        System.setProperty("webdriver.chrome.driver","C:/chromedriver_win32/chromedriver.exe");
//
//        WebDriver driver = new ChromeDriver();
//        driver.get("http://localhost:8080/add-author");
//
//        driver.findElement(By.id("name")).sendKeys("Elnur");
//        driver.findElement(By.id("birthDate")).sendKeys("01.01.1951");
//        driver.findElement(By.id("submit")).click();
//
//        String bodyText = driver.findElement(By.tagName("body")).getText();
//        assertThat(bodyText.contains("Elnur"));
//        assertThat(bodyText.contains("01.01.1951"));
//
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        driver.close();
//    }
}