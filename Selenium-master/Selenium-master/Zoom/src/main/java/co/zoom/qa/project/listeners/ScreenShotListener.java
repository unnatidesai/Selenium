package co.zoom.qa.project.listeners;

import co.zoom.qa.project.base.TestBase;

import co.zoom.qa.project.utils.FrameworkUtils;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ScreenShotListener extends TestBase implements ITestListener  {

    private final Logger logger = LogManager.getLogger(ScreenShotListener.class);

    public ScreenShotListener() throws IOException {
    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
      //  logger.log(Level.ERROR,"Test Failed [] = Doing Screenshot now",ITestResult.FAILURE);

        logger.log(Level.ERROR, "Test Failed {} - Doing Screenshot now", ITestResult.FAILURE);
        FrameworkUtils.takeScreenShot(TestBase.driver(),ITestResult.FAILURE);
      // test.log(Status.FAIL, iTestResult.getName() + "Got Failed");

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
