package com.adb.beautycenter.repository;

import com.adb.beautycenter.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
