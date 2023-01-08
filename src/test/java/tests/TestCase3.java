package tests;

import com.aventstack.extentreports.ExtentTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ExtentReportManager;
import utilities.ScreenshotUtilities;
import utilities.TestBase;
import utilities.TestCaseReports;

import java.io.IOException;
import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class TestCase3 extends TestBase {


        @Test
        public void testTestCase3_LoginWithIncorrectCredentials() throws IOException {
            ExtentReportManager reportManager= TestCaseReports.TestCase1_Report(TestCase3.class,"Report Name : Test Case 3","Document Title : Automation Exercise Test Cases Reports");
            ExtentTest testLogger=reportManager.getExtentReports().createTest("Test Case 3","This is test of Test Case 3 on https://automationexercise.com/test_cases");

            String testEmail="dummy@email.com";
            String testPwd="1234";
            //1. Launch browser
            //2. Navigate to url 'http://automationexercise.com'
            driver.get("http://automationexercise.com");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            testLogger.pass("Home Page Loaded");
            //3. Verify that home page is visible successfully
            boolean isHomePageDisplayed = driver.findElement(By.xpath("//a[@style='color: orange;']")).isDisplayed();   // OR //a[contains(@style,'orange')]
            assertTrue(isHomePageDisplayed);

            ScreenshotUtilities.takeScreenshotOfPage(driver,ScreenshotUtilities.getScreenshotBaseDirWithClassName(TestCase3.class),"Image01");
            testLogger.pass("Verified that home page is visible successfully");

            //4. Click on 'Signup / Login' button
            driver.findElement(By.xpath("//a[@href='/login']")).click();

            //5. Verify 'Login to your account' is visible
            String expectedText="Login to your account";
            String actualText=driver.findElement(By.xpath("//div[@class='login-form']//h2")).getText();
            Assert.assertEquals(expectedText,actualText);
            testLogger.pass("Verified 'Login to your account' is visible");


            //6. Enter incorrect email address and password
            driver.findElement(By.xpath("//form[@action='/login']//input[@name='email']")).sendKeys(testEmail);
            driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys(testPwd);

            ScreenshotUtilities.takeScreenshotOfPage(driver,ScreenshotUtilities.getScreenshotBaseDirWithClassName(TestCase3.class),"Image02");
            testLogger.pass("Entered Test Credentials");

            //7. Click 'login' button
            driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();


            //8. Verify error 'Your email or password is incorrect!' is visible
            expectedText="Your email or password is incorrect!";
            actualText=driver.findElement(By.xpath("//form[@action='/login']//p")).getText();
            Assert.assertEquals(expectedText,actualText);
            testLogger.pass("Verified 'Login to your account' is visible");

            reportManager.flush();

        }

}
