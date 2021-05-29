package com.tenniscope.tenniscope.dto;


import com.tenniscope.tenniscope.entity.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {

    private Long id;
    @NotNull
    private String companyCode;
    @NotNull
    private String name;
    private String description;
    private String address;
    private String mobilePhone;
    private String officePhone;
    private String mailAddress;
    private City city;
    private String district;
}
