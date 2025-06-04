package com.example.excel_uploader_app.service;

import com.example.excel_uploader_app.DTO.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    void saveAll(List<EmployeeDTO> employees);
}