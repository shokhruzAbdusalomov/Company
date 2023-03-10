package com.example.company.controller;


import com.example.company.entity.Company;
import com.example.company.entity.Department;
import com.example.company.entity.Worker;
import com.example.company.payload.DepartmentDto;
import com.example.company.repository.CompanyRepo;
import com.example.company.repository.DepartmentRepo;
import org.hibernate.mapping.DependantBasicValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private CompanyRepo companyRepo;

    @GetMapping("/department")
    public List<Department> getAllDepartment(){
        return departmentRepo.findAll();

    }

    @PostMapping("/addDepartment")
    public String addCompany(@RequestBody DepartmentDto departmentDto) {
        Optional<Company> byId = companyRepo.findById(departmentDto.getCompanyId());
        if (byId.isPresent()){
            Company company1 = byId.get();
            Department department1 = new Department(null,departmentDto.getName(),company1);
            departmentRepo.save(department1);
        }
        else{
            return "address not found";
        }
        return "Saved!";

    }

    @DeleteMapping("department/{id}")
    public String delete(@PathVariable Long id) {
        departmentRepo.deleteById(id);
        return "Deleted!";
    }
    @PutMapping("department/edit/{id}")
    public String update(@RequestBody Department department, @PathVariable Long id) {
        Optional<Department> byId = departmentRepo.findById(id);
        if (byId.isPresent()) {
            Department editedDepartment = byId.get();
            editedDepartment.setId(department.getId());
            editedDepartment.setName(department.getName());
            editedDepartment.setCompany(department.getCompany());
            departmentRepo.save(editedDepartment);
            return "success";
        } else return "department by this id is not found";
    }
}
