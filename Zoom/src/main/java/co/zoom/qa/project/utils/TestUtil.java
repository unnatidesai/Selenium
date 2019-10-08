package co.zoom.qa.project.utils;

import co.zoom.qa.project.base.TestBase;
import org.apache.poi.openxml4j.opc.internal.FileHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class TestUtil extends TestBase {

    public static long PAGE_LOAD_TIMEOUT = 30;
    public static long IMPLICIT_WAIT = 15;
    private static FileHelper FileUtils;


    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }

    // static Workbook book;
    //static Sheet sheet;

    //public static String TESTDATA_SHEET_PATH = "C:\\Users\\RICHA\\Documents\\GitHub\\Selenium\\Zoom\\src\\main\\java\\co\\zoom\\qa\\project\\testdata\\ZoomTestData.xlsx";
    //private static RenderedImageFactory WorkbookFactory;

    public TestUtil() throws IOException {
    }

//   public static Object[][] getTestData(String sheetName){
  //      FileInputStream file = null;
    //    try {
      //      file = new FileInputStream(TESTDATA_SHEET_PATH);
        //} catch (FileNotFoundException e) {
          //  e.printStackTrace();
        //}
        //try {
         //   book = (Workbook) WorkbookFactory.create(file);
        //} catch (IOException e){
          //  e.printStackTrace();
        //}
        //sheet = book.getSheet(sheetName);
        //Object[][] data = new Object[sheet.getLastRowNum()][sheet.getLeftCol()];
        //for (int i = 0; i < sheet.getLastRowNum();i++) {
          //  for (int k = 0; k < sheet.getLeftCol(); k++) {
            //    data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
            //}
        //}
        //return data;
          //  }
}


