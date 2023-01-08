package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {
    private ExtentReports _extentReports;
    private ExtentHtmlReporter _extentHtmlReporter;
    private ExtentTest _logger;

    public ExtentReports getExtentReports() {
        return _extentReports;
    }

    public ExtentHtmlReporter getExtentHtmlReporter() {
        return _extentHtmlReporter;
    }

    public ExtentTest getLogger() {
        return _logger;
    }

    private String _path;

    public String getPath() {
        return _path;
    }

    public void setPath(String path) {
        this._path = path;
        _extentHtmlReporter = new ExtentHtmlReporter(path);
    }

    private String _testName="Default Test Name";
    public String getTestName() {
        return _testName;
    }

    public void setTestName(String testName) {
        this._testName = testName;
    }

    private String _testDescription="Default Test Description";
    public String getTestDescription() {
        return _testDescription;
    }

    public void setTestDescription(String testDescription) {
        this._testDescription = testDescription;
    }

    public ExtentReportManager(String fullPath) {
        _path=fullPath;
        _extentHtmlReporter = new ExtentHtmlReporter(fullPath);
        _extentReports = new ExtentReports(); //.attachReporter(_extentHtmlReporter);
        _extentReports.attachReporter(_extentHtmlReporter);
    }
    public ExtentReportManager(String fullPath, String testName, String testDescription) {
        _path=fullPath;
        _extentHtmlReporter = new ExtentHtmlReporter(fullPath);
        _extentReports = new ExtentReports();
        _extentReports.attachReporter(_extentHtmlReporter);

        _testName=testName;
        _testDescription=testDescription;
        _logger= _extentReports.createTest(_testName,_testDescription);
    }

    public void setSystemInfo(String key,String value){
        _extentReports.setSystemInfo(key,value);
    }

    public void setReportName(String reportName){
        _extentHtmlReporter.config().setReportName(reportName);
    }

    public void setDocumentTitle(String documentTitle){
        _extentHtmlReporter.config().setDocumentTitle(documentTitle);
    }

    public void pass(String passMsg) {
        _logger.pass(passMsg);
    }
    public void info(String infoMsg) {
        _logger.pass(infoMsg);
    }
    public void fail(String failMsg) {
        _logger.pass(failMsg);
    }
    public void skip(String skipMsg) {
        _logger.pass(skipMsg);
    }
    public void warning(String warningMsg) {
        _logger.pass(warningMsg);
    }

    public void flush(){
        _extentReports.flush();
    }

}
