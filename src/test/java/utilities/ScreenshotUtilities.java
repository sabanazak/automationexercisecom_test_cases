package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtilities {

    public static String getBaseDirForScreenshot() {
        return System.getProperty("user.dir")+"/test-outputs/Screenshots/";
    }

    //Base Dir with ClassName
    public static <T> String getScreenshotBaseDirWithClassName(Class<T> sourceClass) {
        String imageDir=System.getProperty("user.dir");
        imageDir += "/test-outputs/" + sourceClass.getSimpleName() + "/Screenshots/";
        return imageDir;
    }

    public static void takeScreenshotOfPage(WebDriver driver) throws IOException {
        takeScreenshotOfPage(driver, getBaseDirForScreenshot());
    }

    public static void takeScreenshotOfPage(WebDriver driver, String baseDir) throws IOException {
        //1. Take screenshot using getScreenshotAs method and TakeScreenshot API-coming from selenium
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //2. Save the screenshot in a path and Save with dynamic name
        String currentTimeAsFileName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); //getting the current local date and time
        String path = baseDir + currentTimeAsFileName + ".png";//Where we save the image
        FileUtils.copyFile(image,new File(path));
    }
    public static void takeScreenshotOfPage(WebDriver driver, String baseDir,String fileName) throws IOException {
        //1. Take screenshot using getScreenshotAs method and TakeScreenshot API-coming from selenium
        File image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //2. Save the screenshot in a path and Save with dynamic name
        String path = baseDir + fileName + ".png";
        FileUtils.copyFile(image,new File(path));
    }
    public static void takeScreenshotOfTheElement(WebElement element) throws IOException {
        //1. Take screenshot of Element
        File imageFile=element.getScreenshotAs(OutputType.FILE);

        //2. Save the screenshot in a path and Save with dynamic name
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());//getting the current local date and time
        String path = System.getProperty("user.dir")+"/test-outputs/Screenshots/"+currentTime+".png";//Where we save the image
        FileUtils.copyFile(imageFile,new File(path));

    }
}
