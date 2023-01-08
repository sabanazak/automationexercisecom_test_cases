package utilities;

public class ReportsUtilies {

    public static <T> String getReportsBaseDir(Class<T>  sourceClass) {
        String reportDir=System.getProperty("user.dir");
        reportDir += "/test-outputs/" + sourceClass.getSimpleName() + "/Reports/";
        return reportDir;
    }





}
