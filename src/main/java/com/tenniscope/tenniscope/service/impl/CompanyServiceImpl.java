package com.tenniscope.tenniscope.service.impl;

import com.tenniscope.tenniscope.dto.CompanyDto;
import com.tenniscope.tenniscope.entity.Company;
import com.tenniscope.tenniscope.repository.CompanyRepository;
import com.tenniscope.tenniscope.service.CompanyService;
import com.tenniscope.tenniscope.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    public CompanyServiceImpl(CompanyRepository companyRepository, ModelMapper modelMapper) {
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public CompanyDto save(CompanyDto companyDto) {

        if (companyDto.getCompanyCode() == null || companyDto.getCompanyCode().equals("")) {
            throw new IllegalArgumentException("Company code cannot be null or empty");
        }

        Company company = modelMapper.map(companyDto, Company.class);
        company = companyRepository.save(company);
        return modelMapper.map(company, CompanyDto.class);
    }

    @Override
    public CompanyDto getById(Long id) {
        Company company = companyRepository.getById(id);
        return modelMapper.map(company, CompanyDto.class);
    }

    @Override
    public TPage<CompanyDto> getAllPageable(Pageable pageable) {
        Page<Company> companyPage = companyRepository.findAll(pageable);
        CompanyDto[] companyDtos = modelMapper.map(companyPage.getContent(), CompanyDto[].class);
        TPage<CompanyDto> companyDtoTPage = new TPage<CompanyDto>();
        companyDtoTPage.setStat(companyPage, Arrays.asList(companyDtos));
        return companyDtoTPage;
    }

    @Override
    public Boolean delete(CompanyDto companyDto) {
        Company company = modelMapper.map(companyDto, Company.class);
        companyRepository.delete(company);
        return true;
    }
}
