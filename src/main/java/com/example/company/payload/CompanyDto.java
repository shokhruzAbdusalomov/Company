package com.example.company.payload;


import com.example.company.entity.Address;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {

    private Long id;
    private String corpName;
    private String dirName;
    private Long addressId;

}
