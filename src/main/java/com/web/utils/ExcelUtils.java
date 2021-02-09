package com.web.utils;

import com.web.constants.FrameworkConstants;
import com.web.exceptions.FrameworkException;
import com.web.exceptions.InvalidExcelPathException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public final class ExcelUtils {

    private ExcelUtils() {
    }

    public static List<Map<String, String>> getTestDetails(String sheetName) {
        XSSFWorkbook workBook;
        List<Map<String, String>> list = null;
        try(FileInputStream file = new FileInputStream(FrameworkConstants.getTestDataFile())) {
            workBook = new XSSFWorkbook(file);
            XSSFSheet sheet = workBook.getSheet(sheetName);
            int lastRowNum = sheet.getLastRowNum();
            int lastColNum = sheet.getRow(0).getLastCellNum();
            Map<String, String> map = null;
            list = new ArrayList<>();
            for (int i = 1; i <= lastRowNum; i++) {
                map = new HashMap<>();
                for (int j = 0; j < lastColNum; j++) {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = null;
                    if (sheet.getRow(i).getCell(j).getCellType() == CellType.STRING) {
                        value = sheet.getRow(i).getCell(j).getStringCellValue();
                    } else if (sheet.getRow(i).getCell(j).getCellType() == CellType.NUMERIC) {
                        value = String.valueOf(sheet.getRow(i).getCell(j).getNumericCellValue());
                    }
                    map.put(key, value);
                }
                list.add(map);
            }
        } catch (FileNotFoundException ex) {
            throw new InvalidExcelPathException("Excel file you trying to read not found at the path specified.");
        }catch (IOException ex){
            throw new FrameworkException("Some error occurred while reading and writing to excel file.");
        }

        return list;
    }


}
