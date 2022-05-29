package managers;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.BaseSetup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * ExcelManager: Implements Excel read/write functions
 *
 * @author Chethan Bidare
 */
public class ExcelManager extends BaseSetup {

    private static final Map<String, String> map = new HashMap<>();
    private static final Properties properties = getProperties();

    public String get(String sheetName, String testCaseName, String columnName) {
        FileInputStream fis;
        int k = 0;
        try {
            fis = new FileInputStream(properties.getProperty("testDataPath"));
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheet(sheetName);
            int rows = sheet.getLastRowNum();
            for (int i = 0; i < rows; i++) {
                int cols = sheet.getRow(0).getLastCellNum();
                XSSFRow row = sheet.getRow(i);
                for (int j = 0; j < cols; j++) {
                    if (row.getCell(j).toString().equalsIgnoreCase(columnName)) {
                        k = j;
                    }
                    map.put(row.getCell(0).toString(),
                            row.getCell(k).toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(map);
        return map.get(testCaseName);
    }
}
