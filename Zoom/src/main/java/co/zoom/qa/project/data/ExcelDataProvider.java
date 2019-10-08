package co.zoom.qa.project.data;

import co.zoom.qa.project.base.TestBase;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelDataProvider extends TestBase {


    private String dataFileName;
    private String dataFileLocation;

    public ExcelDataProvider() throws IOException {
        super();

        dataFileName = "ZoomTestData.xlsx";
        dataFileLocation = "C:\\Users\\RICHA\\Documents\\GitHub\\Selenium\\Zoom\\src\\main\\java\\co\\zoom\\qa\\project\\testdata";

    }


    @DataProvider(name = " ZoomTestData")
    public Iterator<Object[]> readExcel() {
        List<Object[]> excelData = new ArrayList<>();
        Path path = Paths.get(dataFileLocation, dataFileName);

        try (InputStream stream = new FileInputStream(path.toFile())) {
            Workbook workbook = new XSSFWorkbook(stream);
            Sheet sheet = workbook.getSheet("RequestDemo");
            Iterator<Row> rowIterator = sheet.rowIterator();
            rowIterator.next(); // skipped one row
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                List<Object> cellData = new ArrayList<>();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getCellTypeEnum() == CellType.STRING) {
                        cellData.add(cell.getStringCellValue());
                    }
                    if (cell.getCellTypeEnum() == CellType.BOOLEAN) {
                        cellData.add(cell.getBooleanCellValue());
                    }
                    if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                        cellData.add(cell.getNumericCellValue());
                    }
                }
                excelData.add(cellData.toArray());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return excelData.iterator();

    }
}
