package com.example.company.controller;


import com.example.company.entity.Address;
import com.example.company.entity.Company;
import com.example.company.entity.Worker;
import com.example.company.payload.CompanyDto;
import com.example.company.repository.AddressRepo;
import com.example.company.repository.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CompanyController {


    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private AddressRepo addressRepo;


    @GetMapping("/company")
    public List<Company> getAllCompany(){
        return companyRepo.findAll();

    }

    @PostMapping("/addCompany")
    public String addCompany(@ModelAttribute CompanyDto companyDto, Model model) {
        Optional<Address> byId = addressRepo.findById(companyDto.getAddressId());
        if (byId.isPresent()){
            Address address1 = byId.get();
            Company company1 = new Company(null,companyDto.getCorpName(),companyDto.getDirName(),address1);
            companyRepo.save(company1);
        }
        else{
return "address not found";
        }
return "Saved!";

    }

    @DeleteMapping("company/{id}")
    public String delete(@PathVariable Long id) {
        companyRepo.deleteById(id);
        return "Deleted!";
    }
    @PutMapping("editt/{id}")
    public String update(@RequestBody Company company, @PathVariable Long id) {
        Optional<Company> byId = companyRepo.findById(id);
        if (byId.isPresent()) {
            Company editedCompany = byId.get();
            editedCompany.setId(company.getId());
            editedCompany.setCorpName(company.getCorpName());
            editedCompany.setAddress(company.getAddress());
            editedCompany.setDirName(company.getDirName());
            companyRepo.save(editedCompany);
            return "success";
        } else return "company by this id is not found";
    }
}
