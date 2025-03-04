package com.web.utils;

import com.web.constants.FrameworkConstants;
import com.web.exceptions.InvalidPathForExcelException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public final class ExcelUtils {

    private ExcelUtils(){}

    public static List<Map<String,String>> getTestDetails(String sheetName){
        List<Map<String,String>> list = null;

        try(FileInputStream file = new FileInputStream(FrameworkConstants.getExcelPath())) {
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            int lastRowNum = sheet.getLastRowNum();
            int lastColumnNum = sheet.getRow(0).getLastCellNum();

            Map<String,String> map = null;
            list = new ArrayList<>();

            for(int i=1; i<=lastRowNum;i++){
                map = new HashMap<>();
                for (int j=0; j<lastColumnNum;j++){
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key,value);
                }
                list.add(map);
            }

        } catch (FileNotFoundException e) {
            throw new InvalidPathForExcelException("Excel File you are trying to read is not found");
        } catch (IOException e) {
            throw new com.web.exceptions.IOException("Some IO Exception occured while reading excel file");
        }
        return list;
    }

}
