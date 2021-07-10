package com.ada.film.selenium.controller;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ActorControllerTest {


    @Test
    public void testNewUserSuccess() {


        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/actors/new");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.id("submit")).submit();


        driver.findElement(By.id("first_name")).sendKeys("Aydan");
        driver.findElement(By.id("last_name")).sendKeys("Bayramova");
        driver.findElement(By.id("birth_place")).sendKeys("Azerbaijan");
        driver.findElement(By.id("birth_date")).sendKeys("1999-02-02");
        driver.findElement(By.id("submit")).click();

        String bodyText = driver.findElement(By.tagName("body")).getText();
        assertThat(bodyText.contains("Aydan"));
        assertThat(bodyText.contains("Bayramova"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }


}
