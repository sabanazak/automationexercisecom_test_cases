package tests;

import com.aventstack.extentreports.ExtentTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.*;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TestCase2 extends TestBase {


    @Test
    public void testTestCase2_LoginWithCorrectCredentials() throws IOException {
        ExtentReportManager reportManager= TestCaseReports.TestCase1_Report(TestCase2.class,"Report Name : Test Case 2","Document Title : Automation Exercise Test Cases Reports");
        ExtentTest testLogger=reportManager.getExtentReports().createTest("Test Case 2","This is test of Test Case 2 on https://automationexercise.com/test_cases");

        String testName="Saban AZAK";
        String testEmail="saban@azak.com";
        String testPwd="1234";

        //First Greate a User
        TestData.CreateATestUser(driver, testName,testEmail,testPwd);

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.findElement(By.linkText("Home")).click();
        driver.findElement(By.linkText("Logout")).click();

        testLogger.pass("Home Page Loaded");
        //3. Verify that home page is visible successfully
        boolean isHomePageDisplayed = driver.findElement(By.xpath("//a[@style='color: orange;']")).isDisplayed();   // OR //a[contains(@style,'orange')]
        assertTrue(isHomePageDisplayed);

        ScreenshotUtilities.takeScreenshotOfPage(driver,ScreenshotUtilities.getScreenshotBaseDirWithClassName(TestCase2.class),"Image01");
        testLogger.pass("Verified that home page is visible successfully");

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'Login to your account' is visible
        String expectedText="Login to your account";
        String actualText=driver.findElement(By.xpath("//div[@class='login-form']//h2")).getText();
        Assert.assertEquals(expectedText,actualText);
        testLogger.pass("Verified 'Login to your account' is visible");

        //6. Enter correct email address and password
        driver.findElement(By.xpath("//form[@action='/login']//input[@name='email']")).sendKeys(testEmail);
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys(testPwd);

        ScreenshotUtilities.takeScreenshotOfPage(driver,ScreenshotUtilities.getScreenshotBaseDirWithClassName(TestCase2.class),"Image02");
        testLogger.pass("Entered Test Credentials");

        //7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        //8. Verify that 'Logged in as username' is visible
        expectedText="Logged in as";
        actualText=driver.findElement(By.xpath("//div[@class='shop-menu pull-right']//li//a[contains(text(),'Logged in as')]")).getText();
        Assert.assertTrue(actualText.contains(expectedText));
        ScreenshotUtilities.takeScreenshotOfPage(driver,ScreenshotUtilities.getScreenshotBaseDirWithClassName(TestCase2.class),"Image03");
        testLogger.pass("Clicked 'Login' button and Verified that 'Logged in as username' is visible");

        //9. Click 'Delete Account' button
        driver.findElement(By.linkText("Delete Account")).click();

        //10. Verify that 'ACCOUNT DELETED!' is visible
        expectedText="ACCOUNT DELETED!";
        actualText=driver.findElement(By.xpath("//h2[@data-qa='account-deleted']")).getText();
        Assert.assertEquals(expectedText,actualText);

        ScreenshotUtilities.takeScreenshotOfPage(driver,ScreenshotUtilities.getScreenshotBaseDirWithClassName(TestCase2.class),"Image04");
        testLogger.pass("Clicked 'Delete Account' button and Verified that 'ACCOUNT DELETED!' is visible");

        reportManager.flush();
    }

}
