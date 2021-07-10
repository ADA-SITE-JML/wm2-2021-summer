package ada.wm2.firstsb.selenium.controller;
import org.apache.tomcat.jni.Time;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static java.lang.Thread.sleep;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
 class PatientControllerTest {
     @Test
     public void testNewForm() {
         System.setProperty("webdriver.chrome.driver", "/Users/zahidibrahimov/Downloads/chromedriver");
         WebDriver driver = new ChromeDriver();
         driver.get("http://localhost:8080/patient/new");

         driver.findElement(By.id("firstName")).sendKeys("Nargiz");
         driver.findElement(By.id("lastName")).sendKeys("Kazimova");
         driver.findElement(By.id("problem")).sendKeys("headache");
         driver.findElement(By.id("submit")).click();

         String bodyText = driver.findElement(By.tagName("body")).getText();
         assertThat(bodyText.contains("Nargiz"));
         assertThat(bodyText.contains("Kazimova"));

         try {
             Thread.sleep(3000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         driver.close();
     }
}
