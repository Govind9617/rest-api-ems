package com.grt.emsbackend.ems.repo;

import com.grt.emsbackend.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
}
