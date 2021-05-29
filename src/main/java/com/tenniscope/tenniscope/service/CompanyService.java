package com.tenniscope.tenniscope.service;

import com.tenniscope.tenniscope.dto.CompanyDto;
import com.tenniscope.tenniscope.entity.Company;
import com.tenniscope.tenniscope.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompanyService {

    CompanyDto save(CompanyDto companyDto);

    CompanyDto getById(Long id);

    TPage<CompanyDto> getAllPageable(Pageable pageable);

    Boolean delete(CompanyDto companyDto);

    Boolean delete(Long id);

    CompanyDto getCompanyByCompanyCode (String companyCode);

    CompanyDto update (Long id, CompanyDto companyDto);

}
