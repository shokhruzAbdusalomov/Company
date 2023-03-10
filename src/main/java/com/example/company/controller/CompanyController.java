package com.example.company.controller;


import com.example.company.repository.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {


    @Autowired
    private CompanyRepo companyRepo;



}
