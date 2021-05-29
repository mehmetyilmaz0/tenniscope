package com.tenniscope.tenniscope.dto;


import com.tenniscope.tenniscope.entity.City;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Company Data Transfer Object")
public class CompanyDto {

    @ApiModelProperty(name = "Company Id")
    private Long id;
    @NotNull
    @ApiModelProperty(required = true, value = "Code of Company")
    private String companyCode;
    @NotNull
    @ApiModelProperty(required = true, value = "Name of Company")
    private String name;
    @ApiModelProperty(value = "Description of Company")
    private String description;
    @ApiModelProperty(value = "Address of Company Court")
    private String address;
    @ApiModelProperty(value = "Mobile Phone of Company")
    private String mobilePhone;
    @ApiModelProperty(value = "Office Phone of Company")
    private String officePhone;
    @ApiModelProperty(value = "Mail Address of Company")
    private String mailAddress;
    @ApiModelProperty(value = "City of Company")
    private City city;
    @ApiModelProperty(value = "District of Company")
    private String district;
}
