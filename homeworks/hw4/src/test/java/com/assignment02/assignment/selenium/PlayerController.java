package com.assignment02.assignment.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerController {

    private static WebDriver driver;

    @BeforeAll
    static void init() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
        driver = new ChromeDriver();

        driver.get("http://localhost:8080/login");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.className("btn")).click();
    }

    @AfterAll
    static void terminate() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }

    @Test
    @DisplayName("Test filling and saving player form")
    void testCreatePlayer() {
        driver.get("http://localhost:8080/player/create");
        driver.findElement(By.id("firstName")).sendKeys("Harry");
        driver.findElement(By.id("lastName")).sendKeys("Kane");
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

        assertThat(driver.getCurrentUrl()).isEqualTo("http://localhost:8080/player/all");
    }

    @Test
    @DisplayName("Test editing and saving edits to player")
    void testEditPlayer() {
        Long playerId = 1L;

        driver.get("http://localhost:8080/player/all");
        driver.get("http://localhost:8080/player/edit/"  + playerId);
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys("Harry");
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys("Kane");
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

        assertThat(driver.getCurrentUrl()).isEqualTo("http://localhost:8080/player/all");
    }

    @Test
    @DisplayName("Test deleting a player")
    void testDeletePlayer() {
        Long playerId = 3L;
        driver.get("http://localhost:8080/player/delete/" + playerId);
        assertThat(driver.getCurrentUrl()).isEqualTo("http://localhost:8080/player/delete/" + playerId);
    }

    @Test
    @DisplayName("Test becoming free")
    void testBecomeFree() {
        Long playerId = 4L;
        driver.get("http://localhost:8080/player/" + playerId + "/become_free");
        assertThat(driver.getCurrentUrl()).isEqualTo("http://localhost:8080/player/" + playerId + "/become_free");
    }

    @Test
    @DisplayName("Test searching player with name parameter")
    void testSearchPlayer() {
        String name = "Kai";
        driver.get("http://localhost:8080/player/search?name=" + name);
        String bodyText = driver.findElement(By.tagName("body")).getText();
        assertThat(bodyText.contains(name));
    }
}
