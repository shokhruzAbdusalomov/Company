package com.example.company.repository;

import com.example.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company,Long> {

    Integer countByCompany(int numb, Long hotel_id);
}
