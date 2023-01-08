package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import static utilities.UtilityFunctions.checkIFramePopUpForCloseButton;

public class TestData {


    public static void CreateATestUser(WebDriver driver, String name, String email,String pwd){


        driver.get("http://automationexercise.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//a[@href='/login']")).click();

        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.xpath("//form[@action='/signup']//input[@name='email']")).sendKeys(email);

           //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[text()='Signup']")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        boolean isAccountInformationDisplayed=driver.findElement(By.xpath("(//b)[1]")).isDisplayed();
        Assert.assertTrue(isAccountInformationDisplayed);

        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("password")).sendKeys(pwd);

        WebElement days=driver.findElement(By.id("days"));
        WebElement months=driver.findElement(By.id("months"));
        WebElement years=driver.findElement(By.id("years"));

        Select select=new Select(days);
        select.selectByValue("1");

        select=new Select(months);
        select.selectByIndex(1);

        select=new Select(years);
        select.selectByVisibleText("1974");

        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.id("newsletter")).click();

        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.id("optin")).click();

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
        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        String expectedText="ACCOUNT CREATED!";
        String actualText=driver.findElement(By.xpath("//b[text()='Account Created!']")).getText();
        Assert.assertEquals(expectedText,actualText);

        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        //After clicking the Continue Button; an Ad Popup appears
        //Handle for Ad Popoup
        /*List<WebElement> iframes=driver.findElements(By.xpath("//iframe"));
        boolean flag=false;
        for(WebElement iframe:iframes){
            try{
                WebElement closeButton= checkIFramePopUpForCloseButton(driver,iframe);
                if(closeButton!=null){
                    closeButton.click();
                    driver.switchTo().defaultContent();
                    break;
                }
            }
            catch(NotFoundException e) {}
        }*/

    }

}
