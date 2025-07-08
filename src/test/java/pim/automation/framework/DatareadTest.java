package pim.automation.framework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DatareadTest {
	public static void main(String[] args) throws IOException {
		String filepath = "C:\\PIM_Automation\\2025_PIM_Updated\\src\\test\\resources\\Test.xlsx";
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		String ActSheetname = "Regionin Override";
		
		/***************************************
		 * To get all the worksheets and stop and get the desired index
		***************************************/
		int sheetindex = 0;
		int totalSheets = wb.getNumberOfSheets();
		for (int i = 0; i < totalSheets; i++) {
            System.out.println("Sheet " + (i + 1) + ": " + wb.getSheetName(i));
			if(wb.getSheetName(i).equals(ActSheetname)){
				System.out.println("Sheet " + ActSheetname + " is found at sheet index " + i+1);
				sheetindex = i;
				break;
			}
		}
		/***************************************
		 * From the sheet get all the rows in the first column (Key to update values)
		***************************************/
		XSSFSheet sheet = wb.getSheetAt(sheetindex);
		XSSFRow headerrow = sheet.getRow(0);
		int colcount = headerrow.getLastCellNum();
		
		int preEtlUpdateColIndex = -1;
        for (int col = 0; col < colcount; col++) {
            XSSFCell cell = headerrow.getCell(col);
            if (cell != null && cell.getStringCellValue().trim().equalsIgnoreCase("Pre_ETLUpdate")) {
                preEtlUpdateColIndex = col;
                break;
            }
        }
        
        
        if (preEtlUpdateColIndex == -1) {
            System.out.println("Column 'Pre_ETLUpdate' not found");
            wb.close();
            return;
        }
		
     // Read all rows under the first column and "Pre_ETL_Update" column
        int lastRow = sheet.getLastRowNum();
        Map<String, String> keyValueMap = new HashMap<>();

        for (int i = 1; i <= lastRow; i++) {
            XSSFRow row = sheet.getRow(i);
            if (row != null) {
                XSSFCell keyCell = row.getCell(0); 
                XSSFCell valueCell = row.getCell(preEtlUpdateColIndex);

                String key = (keyCell != null) ? keyCell.toString().trim() : "";
                String value = (valueCell != null) ? valueCell.toString().trim() : "";
                if (!key.isEmpty()) {
                    keyValueMap.put(key, value);
                }
            }
        }

        // Print results
        for (Map.Entry<String, String> entry : keyValueMap.entrySet()) {
            System.out.println(entry.getKey() + " --- " + entry.getValue());
        }

	}
}
