package org.example.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin {

    @Test
    public void testVWOLogin(){

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");

        ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
        chromeDriver.get("https://app.vwo.com/#/login");
        chromeDriver.findElement(By.id("login-username")).sendKeys("admin@admin.com");
        chromeDriver.findElement(By.id("login-password")).sendKeys("password@321");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        chromeDriver.findElement(By.id("js-login-btn")).click();

        WebElement err_msg = chromeDriver.findElement(By.className("notification-box-description"));
        String error_msg_txt = err_msg.getText();
        String error_attribute = err_msg.getAttribute("data-qa");
        System.out.println(error_attribute);

        Assert.assertEquals(error_msg_txt, "Your email, password, IP address or location did not match");
        chromeDriver.quit();
    }
}
