package com.example.company.controller;


import com.example.company.entity.Address;
import com.example.company.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @PutMapping("address/edit/{id}")
    public String update(@RequestBody Address address, @PathVariable Long id) {
        Optional<Address> byId = addressRepo.findById(id);
        if (byId.isPresent()) {
            Address editedAddress = byId.get();
            editedAddress.setId(address.getId());
            editedAddress.setStreet(address.getStreet());
            editedAddress.setHomeNumb(address.getHomeNumb());
            addressRepo.save(editedAddress);
            return "success";
        } else return "address by this id is not found";
    }



}
