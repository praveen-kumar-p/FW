package org.example.tests.vwoTests;


import org.example.base.*;
import org.example.driver.DriverManager;
import org.example.pages.pageObjectModel.LoginPage_POM;
import org.example.utils.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestVWOLogin_POM {

//    private static final Logger logger = LogManager.getLogger(TestVWOLogin_POM.class);

    @BeforeTest
    public void setUp(){
        DriverManager.init();
    }

    @Test
    public void testLoginNegativeVWO() {
        LoginPage_POM loginPagePom = new LoginPage_POM(DriverManager.getDriver());
        String error_msg_text = loginPagePom.loginToVWOInvalidCreds(PropertyReader.readKey("invalid_username"), PropertyReader.readKey("invalid_password"));
        Assert.assertEquals(error_msg_text, PropertyReader.readKey("error_message"));

    }

    @AfterTest
    public void tearDown(){
        DriverManager.down();
    }
}
