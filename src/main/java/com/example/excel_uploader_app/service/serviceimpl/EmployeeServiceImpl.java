package com.example.excel_uploader_app.service.serviceimpl;

import com.example.excel_uploader_app.DTO.EmployeeDTO;
import com.example.excel_uploader_app.entity.EmployeeEntity;
import com.example.excel_uploader_app.exceptions.Types.GeneralServiceException;
import com.example.excel_uploader_app.mapper.EmployeeMapper;
import com.example.excel_uploader_app.repository.EmployeeRepository;
import com.example.excel_uploader_app.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public void saveAll(List<EmployeeDTO> employees) {
        try {
            List<EmployeeEntity> entities = employeeMapper.toEntityList(employees);
            employeeRepository.saveAll(entities);
            log.info("Saved {} employees to the database.", entities.size());
        } catch (Exception ex) {
            log.error("Failed to save employees", ex);
            throw new GeneralServiceException("Error occurred while saving employee data.", ex);
        }
    }
}