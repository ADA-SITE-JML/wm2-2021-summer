package com.hw2.blog.selenium.controller;

import com.google.j2objc.annotations.Property;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.lang.model.element.Element;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PostControllerTest {

    static private WebDriver driver;

    @AfterAll
    static void exit(){
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();;
        }

        driver.get("http://localhost:8080/logout");

        driver.close();
    }


    @BeforeAll
    static void init(){
        System.setProperty("webdriver.chrome.driver", "/Users/feqanrasulov/Desktop/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/posts/");

        // login
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.tagName("button")).submit();

        // switch profile
        driver.findElement(By.id("username_id")).sendKeys("admin");
        driver.findElement(By.id("password_id")).sendKeys("admin");
        driver.findElement(By.tagName("button")).submit();
    }


    @Test
    @DisplayName("Create New Post")
    public void testNewPostCreate(){

        // click to all posts
        driver.findElement(By.id("all-posts")).click();

        String post_title = "New Automated Post";
        String post_body = "My automated post body. \nLorem ipsum dolor sit amet, consectetur adipisicing elit. Ad amet harum numquam suscipit tempore. Cumque dolorem dolores earum fuga fugiat laborum nam, nisi, optio porro recusandae repudiandae rerum sit voluptate.";

        // create post form
        driver.findElement(By.id("post_title")).sendKeys(post_title);
        driver.findElement(By.id("floatingTextarea2")).sendKeys(post_body);
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).submit();


        String bodyText = driver.findElement(By.tagName("body")).getText();
        assertThat(bodyText.contains(post_title));
        assertThat(bodyText.contains(post_body));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @Test
    @DisplayName("Edit Post")
    public void editPost(){
        String post_id = "8"; //

        String edit_url = "http://localhost:8080/posts/edit/"+post_id;

        // go to edit page
        driver.get(edit_url);

        assertThat(edit_url).isEqualTo(driver.getCurrentUrl());

        String post_title = "Updated Automated Post";
        String image_link = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg";

        // update post form
        WebElement post_title_element = driver.findElement(By.id("post_title"));
        post_title_element.clear();
        post_title_element.sendKeys(post_title);

        WebElement post_image_element = driver.findElement(By.id("post_image"));
        post_image_element.clear();
        post_image_element.sendKeys(image_link);
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).submit();
    }

    @Test
    @DisplayName("Edit Post which is not Allowed!")
    public void editPostNotAllowed(){
        String post_id = "3"; //
        String edit_url = "http://localhost:8080/posts/edit/"+post_id;
        driver.get(edit_url);
        assertThat(edit_url).isNotEqualTo(driver.getCurrentUrl());

    }


    @Test
    @DisplayName("Delete Post")
    public void deletePost(){
        String post_id = "7";
        driver.get("http://localhost:8080/posts/");
        System.out.println("form[action=\"/posts/delete/"+post_id+"\"]");
        driver.findElement(By.cssSelector("form[action=\"/posts/delete/"+post_id+"\"]")).submit();

    }

}
