package com.example.excel_uploader_app.mapper;

import com.example.excel_uploader_app.DTO.EmployeeDTO;
import com.example.excel_uploader_app.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeEntity toEntity(EmployeeDTO dto);
    EmployeeDTO toDTO(EmployeeEntity entity);
    List<EmployeeEntity> toEntityList(List<EmployeeDTO> dtoList);
}