package com.grt.emsbackend.ems.service;

import com.grt.emsbackend.ems.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeebyId(Long employeeId);

    List<EmployeeDto> getAllEmployee();

    EmployeeDto updateEmployee(Long employeeId,EmployeeDto employeeDto);

    void deleteEmployee(Long employeeId);


}
