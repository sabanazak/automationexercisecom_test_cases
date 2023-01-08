package tests;

import com.aventstack.extentreports.ExtentTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ExtentReportManager;
import utilities.ScreenshotUtilities;
import utilities.TestBase;
import utilities.TestCaseReports;

import java.io.IOException;
import java.sql.DataTruncation;
import java.time.Duration;

public class TestCase1 extends TestBase {
    @Test
    public void testTestCase1_RegisterUser() throws InterruptedException, IOException {
        ExtentReportManager reportManager= TestCaseReports.TestCase1_Report(TestCase1.class,"Report Name : Test Case 1","Document Title : Automation Exercise Test Cases Reports");
        ExtentTest testLogger=reportManager.getExtentReports().createTest("Test Case 1","This is test of Test Case 1 on https://automationexercise.com/test_cases");

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        testLogger.pass("Home Page Loaded");

        //3. Verify that home page is visible successfully
        String expectedTitle="Automation Exercise";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        ScreenshotUtilities.takeScreenshotOfPage(driver,ScreenshotUtilities.getScreenshotBaseDirWithClassName(TestCase1.class),"Image01");
        testLogger.pass("Verified that home page is visible successfully");

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        //5. Verify 'New User Signup!' is visible
        String expectedText="New User Signup!";
        String actualText=driver.findElement(By.xpath("//div[@class='signup-form']//h2")).getText();
        Assert.assertEquals(expectedText,actualText);
        testLogger.pass("Verified 'New User Signup!' is visible");

        //6. Enter name and email address
        driver.findElement(By.name("name")).sendKeys("Saban AZAK");
        driver.findElement(By.xpath("//form[@action='/signup']//input[@name='email']")).sendKeys("saban@azak.com");

        ScreenshotUtilities.takeScreenshotOfPage(driver,ScreenshotUtilities.getScreenshotBaseDirWithClassName(TestCase1.class),"Image02");
        testLogger.pass("Entered name and email address");

        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[text()='Signup']")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        boolean isAccountInformationDisplayed=driver.findElement(By.xpath("(//b)[1]")).isDisplayed();
        Assert.assertTrue(isAccountInformationDisplayed);

        ScreenshotUtilities.takeScreenshotOfPage(driver,ScreenshotUtilities.getScreenshotBaseDirWithClassName(TestCase1.class),"Image03");
        testLogger.pass("Verified that 'ENTER ACCOUNT INFORMATION' is visible");

        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.id("id_gender1")).click();
        //driver.findElement(By.id("name")).sendKeys("Saban AZAK");
        //driver.findElement(By.id("email")).sendKeys("saban@azak.com");
        driver.findElement(By.id("password")).sendKeys("1234");

        WebElement days=driver.findElement(By.id("days"));
        WebElement months=driver.findElement(By.id("months"));
        WebElement years=driver.findElement(By.id("years"));

        Select select=new Select(days);
        select.selectByValue("1");

        select=new Select(months);
        select.selectByIndex(1);

        select=new Select(years);
        select.selectByVisibleText("1974");

        testLogger.pass("Filled details: Title, Name, Email, Password, Date of birth");

        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.id("newsletter")).click();

        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.id("optin")).click();

        testLogger.pass("Selected checkbox 'Sign up for our newsletter!\nSelected checkbox 'Receive special offers from our partners!");

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.id("first_name")).sendKeys("Saban");
        driver.findElement(By.id("last_name")).sendKeys("AZAK");
        driver.findElement(By.id("company")).sendKeys("M2S Ltd");
        driver.findElement(By.id("address1")).sendKeys("My address line 1");
        driver.findElement(By.id("address2")).sendKeys("My address line 2");

        select=new Select(driver.findElement(By.id("country")));
        select.selectByValue("Canada");

        driver.findElement(By.id("state")).sendKeys("Ontario");
        driver.findElement(By.id("city")).sendKeys("Totonto");
        driver.findElement(By.id("zipcode")).sendKeys("N2N2N2");
        driver.findElement(By.id("mobile_number")).sendKeys("222-333-4455");

        ScreenshotUtilities.takeScreenshotOfPage(driver,ScreenshotUtilities.getScreenshotBaseDirWithClassName(TestCase1.class),"Image04");
        testLogger.pass("Filled details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number");
        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        expectedText="ACCOUNT CREATED!";
        actualText=driver.findElement(By.xpath("//b[text()='Account Created!']")).getText();
        Assert.assertEquals(expectedText,actualText);

        ScreenshotUtilities.takeScreenshotOfPage(driver,ScreenshotUtilities.getScreenshotBaseDirWithClassName(TestCase1.class),"Image05");
        testLogger.pass("Clicked 'Create Account button and Verified that 'ACCOUNT CREATED!' is visible");
        //15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        //16. Verify that 'Logged in as username' is visible
        expectedText="Logged in as";
        actualText=driver.findElement(By.xpath("//div[@class='shop-menu pull-right']//li//a[contains(text(),'Logged in as')]")).getText();
        Assert.assertTrue(actualText.contains(expectedText));
        ScreenshotUtilities.takeScreenshotOfPage(driver,ScreenshotUtilities.getScreenshotBaseDirWithClassName(TestCase1.class),"Image06");
        testLogger.pass("Clicked 'Continue' button and Verified that 'Logged in as username' is visible");

        //17. Click 'Delete Account' button
        driver.findElement(By.linkText("Delete Account")).click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        expectedText="ACCOUNT DELETED!";
        actualText=driver.findElement(By.xpath("//h2[@data-qa='account-deleted']")).getText();
        Assert.assertEquals(expectedText,actualText);

        ScreenshotUtilities.takeScreenshotOfPage(driver,ScreenshotUtilities.getScreenshotBaseDirWithClassName(TestCase1.class),"Image07");
        testLogger.pass("Clicked 'Delete Account' button and Verified that 'ACCOUNT DELETED!' is visible");

        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        ScreenshotUtilities.takeScreenshotOfPage(driver,ScreenshotUtilities.getScreenshotBaseDirWithClassName(TestCase1.class),"Image08");
        testLogger.pass("Clicked 'Continue' button");

        reportManager.flush();
    }


}
