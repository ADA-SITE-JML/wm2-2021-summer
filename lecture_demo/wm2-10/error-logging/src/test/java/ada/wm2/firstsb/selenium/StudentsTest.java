package ada.wm2.firstsb.selenium;

import ada.wm2.firstsb.FirstSbApplication;
import org.apache.tomcat.jni.Time;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StudentsTest {

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
        assertThat(bodyText.contains("ah@ada.edu.az"));
//        driver.close();
    }
}
