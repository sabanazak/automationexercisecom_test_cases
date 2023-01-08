package utilities;

public class ReportsUtilies {

    public static <T> String getReportsBaseDir(Class<T>  sourceClass) {
        return  AppsUtilityFunctions.getReportsBaseDir(sourceClass,"Reports");
    }





}
