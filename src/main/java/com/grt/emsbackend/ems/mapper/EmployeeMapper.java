package com.grt.emsbackend.ems.mapper;

import com.grt.emsbackend.ems.dto.EmployeeDto;
import com.grt.emsbackend.ems.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getFirstName(),
                employeeDto.getEmail());
    }
}
