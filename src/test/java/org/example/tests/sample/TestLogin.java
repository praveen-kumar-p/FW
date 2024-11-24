package org.example.tests.sample;

import org.example.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLogin {

    @BeforeTest
    public void setUp(){
        DriverManager.init();
    }
    @Test
    public void testVWOLogin(){

        WebDriver driver = DriverManager.getDriver();
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        driver.findElement(By.id("login-username")).sendKeys("admin@admin.com");
        driver.findElement(By.id("login-password")).sendKeys("password@321");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.id("js-login-btn")).click();

        WebElement err_msg = driver.findElement(By.className("notification-box-description"));
        String error_msg_txt = err_msg.getText();
        String error_attribute = err_msg.getAttribute("data-qa");
        System.out.println(error_attribute);

//        Assert.assertEquals(error_msg_txt, "Your email, password, IP address or location did not match");
        driver.quit();
    }
}
