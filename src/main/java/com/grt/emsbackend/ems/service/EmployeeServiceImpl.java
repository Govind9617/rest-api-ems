package com.grt.emsbackend.ems.service;

import com.grt.emsbackend.ems.dto.EmployeeDto;
import com.grt.emsbackend.ems.entity.Employee;
import com.grt.emsbackend.ems.exceptions.ResourceNotNotFoundException;
import com.grt.emsbackend.ems.mapper.EmployeeMapper;
import com.grt.emsbackend.ems.repo.EmployeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmp = employeeRepo.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmp);
    }

    @Override
    public EmployeeDto getEmployeebyId(Long employeeId) {
        Employee employee = employeeRepo.findById(employeeId).
                orElseThrow(() -> new ResourceNotNotFoundException("employee not exist"));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> allEmployees = employeeRepo.findAll();
        return allEmployees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
        Employee employee = employeeRepo.findById(employeeId).orElseThrow(() -> new ResourceNotNotFoundException("emp not exist"));
        employee.setFirstName(updateEmployee.getFirstName());
        employee.setFirstName(updateEmployee.getLastName());
        employee.setFirstName(updateEmployee.getEmail());

        Employee saveEmployee = employeeRepo.save(employee);
        return EmployeeMapper.mapToEmployeeDto(saveEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepo.findById(employeeId).orElseThrow(() -> new ResourceNotNotFoundException("not there id"));
        employeeRepo.delete(employee);
    }
}
