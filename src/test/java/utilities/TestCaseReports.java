package utilities;

import com.aventstack.extentreports.ExtentReports;
import org.apache.poi.ss.formula.functions.T;

public class TestCaseReports {

    public static <T> ExtentReportManager TestCase1_Report(Class<T>  sourceClass,
                                                           String reportName, String documentTitle) {

        String  fullPath=ReportsUtilies.getReportsBaseDir(sourceClass)+"_" + sourceClass.getSimpleName() +"_html_report.html";

        ExtentReportManager RM=new ExtentReportManager(fullPath);
        RM.getExtentHtmlReporter().config().setReportName(reportName);
        RM.getExtentHtmlReporter().config().setDocumentTitle(documentTitle);  //Web Page/Tab Title

        RM.getExtentReports().setSystemInfo("Test Environment","Regression");
        RM.getExtentReports().setSystemInfo("Application","Automation Exercise");
        RM.getExtentReports().setSystemInfo("Browser","Chrome");
        RM.getExtentReports().setSystemInfo("Team","B108-109");
        RM.getExtentReports().setSystemInfo("SQA","S.A.");

        return RM;
    }


}
