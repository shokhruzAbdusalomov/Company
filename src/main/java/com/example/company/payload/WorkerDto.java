package com.example.company.payload;

import com.example.company.entity.Address;
import com.example.company.entity.Department;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkerDto {

    private Long id;
    private String name;
    private Long phoneNumb;
    private Long addressId;
    private Long departmentId;
}
