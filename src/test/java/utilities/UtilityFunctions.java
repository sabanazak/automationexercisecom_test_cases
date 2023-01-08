package utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilityFunctions {

    public static String createDynamicFileName(String extension){
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String fileName =  currentTime+extension;
        return fileName;
    }

    public static WebElement checkIFramePopUpForCloseButton(WebDriver driver, WebElement iframe) {
        WebElement closeAdButton=null;
        try{
            driver.switchTo().frame(iframe);
            closeAdButton = driver.findElement(By.id("dismiss-button"));
        }
        catch(NotFoundException e) {
            return null;
        }
        return closeAdButton;
    }

}
