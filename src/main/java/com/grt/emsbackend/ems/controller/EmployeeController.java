package com.grt.emsbackend.ems.controller;

import com.grt.emsbackend.ems.dto.EmployeeDto;
import com.grt.emsbackend.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emp")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto saveEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeebyId = employeeService.getEmployeebyId(employeeId);
        return ResponseEntity.ok(employeebyId);
    }
    @GetMapping("/allEmps")
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        List<EmployeeDto> allEmployee = employeeService.getAllEmployee();
        return ResponseEntity.ok(allEmployee);
    }
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto employeeDto){
        EmployeeDto updateEmployee=  employeeService.updateEmployee(employeeId,employeeDto);
        return ResponseEntity.ok(updateEmployee);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("deleted");
    }
}
