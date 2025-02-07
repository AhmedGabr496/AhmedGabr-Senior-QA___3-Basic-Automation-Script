package testrunner;


import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import setup.Setup;
import utils.Utils;

import java.io.IOException;

public class LoginPageTestRunner extends Setup {
    DashboardPage dashboardPage;
    LoginPage loginPage;
    Utils utils;

    @Test(priority = 1, description = "User can do login with valid Creds")
    public void doLogin() throws IOException, ParseException, InterruptedException {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        String username, password;
        JSONObject credntials = Utils.loadJSONFile("./src/test/resources/Admin.json");

        if (System.getProperty("username") != null && System.getProperty("password") != null) {
            username = System.getProperty("username");
            password = System.getProperty("password");
        } else {
            username = (String) credntials.get("username");
            password = (String) credntials.get("password");
        }

        loginPage.doLogin(username,password);
        WebElement headerText = driver.findElement(By.tagName("h6"));
        String actual_headerText = headerText.getText();
        String expected_headerText = "Dashboard";
        Assert.assertEquals(actual_headerText,expected_headerText);
        Thread.sleep(1500);
        dashboardPage.menus.get(1).click();
        Thread.sleep(1500);

    }

    @Test(priority = 2,description = "User cannot login with invalid creds")
    public void doLoginWithInvalidCreds() throws InterruptedException {
        loginPage = new LoginPage(driver);
        String actual_msg = loginPage.doLoggingWithInvalidCreds("admin","1234567");
        String expected_msg ="Invalid credentials";
        Assert.assertTrue(actual_msg.contains(expected_msg));
        Thread.sleep(1500);
    }

    








}
