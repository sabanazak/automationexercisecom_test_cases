package utilities;

public class AppsUtilityFunctions {
    /* ===========================================
    Functions which can be used in only this tests
     ===========================================*/
    public static <T> String getReportsBaseDir(Class<T>  sourceClass, String subDir) {
        String reportDir=System.getProperty("user.dir");
        reportDir += "/test-outputs/" + sourceClass.getSimpleName() + "/" + subDir + "/";
        return reportDir;
    }

}
