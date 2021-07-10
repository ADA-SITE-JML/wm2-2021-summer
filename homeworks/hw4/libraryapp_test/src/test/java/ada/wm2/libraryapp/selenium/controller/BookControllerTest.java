package ada.wm2.libraryapp.selenium.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;

public class BookControllerTest {


    @Test
    public void testAddNewBookSuccess(){

        System.setProperty("webdriver.chrome.driver","C:/webdrivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/book/addBook");


        driver.findElement(By.id("name")).sendKeys("qwert");
        driver.findElement(By.id("description")).sendKeys("asdfg");
        driver.findElement(By.id("author")).sendKeys("zxcvb");;
        driver.findElement(By.id("submit")).click();

        String bodyText = driver.findElement(By.tagName("body")).getText();
        assertThat(bodyText.contains("qwert"));
        assertThat(bodyText.contains("zxcvb"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();

    }


    @Test
    @DisplayName("Delete a book")
    void testDeleteBook() {
        System.setProperty("webdriver.chrome.driver","C:/webdrivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/book/" + 1);
        assertThat(driver.getCurrentUrl()).isEqualTo("http://localhost:8080/book/" + 1);


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
