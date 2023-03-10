package com.example.company.controller;


import com.example.company.entity.Address;
import com.example.company.entity.Company;
import com.example.company.entity.Department;
import com.example.company.entity.Worker;
import com.example.company.payload.DepartmentDto;
import com.example.company.payload.WorkerDto;
import com.example.company.repository.AddressRepo;
import com.example.company.repository.CompanyRepo;
import com.example.company.repository.DepartmentRepo;
import com.example.company.repository.WorkerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WorkerController {

    @Autowired
    private WorkerRepo workerRepo;

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    @GetMapping("/worker")
    public List<Worker> getAllWorker() {
        return workerRepo.findAll();

    }

    @PostMapping("/addWorker")
    public String addWorker(@RequestBody WorkerDto workerDto) {
        Optional<Department> byId = departmentRepo.findById(workerDto.getDepartmentId());
        Optional<Address> byId1 = addressRepo.findById(workerDto.getDepartmentId());
        if (byId.isPresent() && byId1.isPresent()) {
            Department department1 = byId.get();
            Address address1 = byId1.get();
            Worker worker1 = new Worker(null, workerDto.getName(), workerDto.getPhoneNumb(), address1, department1);
            workerRepo.save(worker1);
        } else {
            return "address not found";
        }
        return "Saved!";

    }

    @DeleteMapping("worker/{id}")
    public String delete(@PathVariable Long id) {
        workerRepo.deleteById(id);
        return "Deleted!";
    }

    @PutMapping("worker/edit/{id}")
    public String update(@RequestBody Worker worker, @PathVariable Long id) {
        Optional<Worker> byId = workerRepo.findById(id);
        if (byId.isPresent()) {
            Worker editedWorker = byId.get();
            editedWorker.setId(worker.getId());
            editedWorker.setName(worker.getName());
            editedWorker.setAddress(worker.getAddress());
            editedWorker.setPhoneNumb(worker.getPhoneNumb());
            workerRepo.save(editedWorker);
            return "success";
        } else return "worker by this id is not found";
    }
}
