package com.example.excel_uploader_app;

import com.example.excel_uploader_app.service.EmployeeService;
import com.example.excel_uploader_app.utils.ExcelParserUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoadRunner implements ApplicationRunner {

    private final ExcelParserUtil excelParserUtil;
    private final EmployeeService employeeService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Loading employee data from Excel...");
        var resource = new ClassPathResource("employees.xlsx");
        var employees = excelParserUtil.parseExcel(resource.getInputStream());
        employeeService.saveAll(employees);
        log.info("Employee data load completed.");
    }
}
