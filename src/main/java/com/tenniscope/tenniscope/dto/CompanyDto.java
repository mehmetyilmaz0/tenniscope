package com.tenniscope.tenniscope.dto;

import com.tenniscope.tenniscope.entity.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {

    private Long id;
    private String companyCode;
    private String name;
    private String description;
    private String address;
    private String mobilePhone;
    private String officePhone;
    private String mailAddress;
    private City city;
    private String district;
}
