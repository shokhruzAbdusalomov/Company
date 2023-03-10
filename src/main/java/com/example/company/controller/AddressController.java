package com.example.company.controller;


import com.example.company.entity.Address;
import com.example.company.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {


    @Autowired
    private AddressRepo addressRepo;

    @GetMapping("/address")
    public List<Address> getAllAddress(){
        return addressRepo.findAll();

    }

    @PostMapping("/addAddress")
    public String addAddress(@RequestBody Address address){
        addressRepo.save(address);
        return "Saved!";
    }



}
