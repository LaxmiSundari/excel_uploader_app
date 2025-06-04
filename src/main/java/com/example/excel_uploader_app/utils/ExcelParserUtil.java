package com.example.excel_uploader_app.utils;

import com.example.excel_uploader_app.DTO.EmployeeDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class ExcelParserUtil {

    public List<EmployeeDTO> parseExcel(InputStream is) {
        List<EmployeeDTO> list = new ArrayList<>();
        try (Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            boolean isHeader = true;
            for (Row row : sheet) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                EmployeeDTO dto = EmployeeDTO.builder()
                        .name(row.getCell(0).getStringCellValue())
                        .department(row.getCell(1).getStringCellValue())
                        .joiningDate(row.getCell(2).getLocalDateTimeCellValue().toLocalDate())
                        .salary(row.getCell(3).getNumericCellValue())
                        .build();
                list.add(dto);
            }
        } catch (Exception e) {
            log.error("Error parsing Excel file", e);
            throw new RuntimeException("Invalid Excel format");
        }
        return list;
    }

}
