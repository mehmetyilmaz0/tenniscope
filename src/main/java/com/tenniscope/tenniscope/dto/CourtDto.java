package com.tenniscope.tenniscope.dto;

import com.tenniscope.tenniscope.entity.Company;
import com.tenniscope.tenniscope.entity.CourtType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Court Data Transfer Object")
public class CourtDto {

    @ApiModelProperty(value = "Court Id")
    private Long id;
    @NotNull
    @ApiModelProperty(required = true, value = "Name of Court")
    private String name;
    @ApiModelProperty(value = "Description of Court")
    private String description;
    @ApiModelProperty(value = "Court Type of Court")
    private CourtType courtType;
    @ApiModelProperty(value = "Company of Court")
    private CompanyDto company;
}
