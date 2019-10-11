package co.zoom.qa.project.utils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FrameworkUtils {

    public static void takeScreenShot(WebDriver driver, int tcName){

        String filename = getFileName(tcName);

        Path path = Paths.get("target","screenshot");
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        Path diskFile = Paths.get("target/screenshot",filename);
        try {
            InputStream stream = new FileInputStream(screenShot);
            Files.copy(stream,diskFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getFileName(int tcName){
        SimpleDateFormat format = new SimpleDateFormat("YYYYMMDDHHmmssSSS");
        return tcName+"_"+format.format(new Date())+".png";
    }
}
