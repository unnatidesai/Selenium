package co.zoom.qa.project.reports;


import co.zoom.qa.project.base.TestBase;
import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HtmlReport extends TestBase {

    private static ExtentHtmlReporter reporter;
    private static ExtentReports reports;

    private HtmlReport() throws IOException {
        super();

        Path path = Paths.get("report.html");
        reporter = new ExtentHtmlReporter(path.toFile());
        reports = new ExtentReports();
        reports.attachReporter(reporter);
    }

    public static ExtentReports getReportInstance() throws IOException {
        if(reporter==null){
            new HtmlReport();
        }
        return reports;
    }



}
