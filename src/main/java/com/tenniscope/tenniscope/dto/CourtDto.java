package com.tenniscope.tenniscope.dto;

import com.tenniscope.tenniscope.entity.Company;
import com.tenniscope.tenniscope.entity.CourtType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourtDto {

    private Long id;
    private String name;
    private String description;
    private CourtType courtType;
    private CompanyDto company;
}
