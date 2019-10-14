package co.zoom.qa.project.data;

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

public class ExcelDataProvider {
    private String dataFileName;
    private String dataFileLocation;

    public ExcelDataProvider() {

        dataFileName = "ZoomTestData.xlsx";
        dataFileLocation = "src/main/resources";
    }

    public ExcelDataProvider(String dataFileName, String dataFileLocation) {
        this.dataFileName = dataFileName;
        this.dataFileLocation = dataFileLocation;
    }

    @DataProvider(name = "excelData")
    public Iterator<Object[]> readExcel() {
        List<Object[]> excelData = new ArrayList<>();
        Path path = Paths.get(dataFileLocation, dataFileName);

        try (InputStream stream = new FileInputStream(path.toFile())) {
            Workbook workbook = new XSSFWorkbook(stream);
            Sheet sheet = workbook.getSheet("contacts");
            Iterator<Row> rowIterator = sheet.rowIterator();
            rowIterator.next(); // skipped one row
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                List<Object> cellData = new ArrayList<>();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                        cellData.add(cell.getStringCellValue());
                    }
                    if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
                        cellData.add(cell.getBooleanCellValue());
                    }
                    if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
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
