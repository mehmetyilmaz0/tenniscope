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

        Company isExistCompanyCode = companyRepository.getCompanyByCompanyCode(companyDto.getCompanyCode());
        if (isExistCompanyCode != null) {
            throw new IllegalArgumentException("Company Code already exist!");
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

    @Override
    public Boolean delete(Long id) {
        Company isExistId = companyRepository.getById(id);
        if (isExistId == null) {
            throw new IllegalArgumentException("Company id not found");
        }

        companyRepository.deleteById(id);
        return true;
    }

    @Override
    public CompanyDto getCompanyByCompanyCode(String companyCode) {
        Company company = companyRepository.getCompanyByCompanyCode(companyCode);
        CompanyDto companyDto = modelMapper.map(company, CompanyDto.class);
        return companyDto;
    }

    @Override
    public CompanyDto update(Long id, CompanyDto companyDto) {
        Company isExistId = companyRepository.getById(id);
        if (isExistId == null)
            throw new IllegalArgumentException("Company id does not exist");

        Company isExistCompanyCode = companyRepository.getCompanyByCompanyCode(companyDto.getCompanyCode());
        if (isExistCompanyCode != null && !isExistCompanyCode.getCompanyCode().equals(isExistId.getCompanyCode()))
            throw new IllegalArgumentException("Company code already exist");

        isExistId.setCompanyCode(companyDto.getCompanyCode());
        isExistId.setName(companyDto.getName());
        isExistId.setAddress(companyDto.getAddress());
        isExistId.setCity(companyDto.getCity());
        isExistId.setDescription(companyDto.getDescription());
        isExistId.setDistrict(companyDto.getDistrict());
        isExistId.setMailAddress(companyDto.getMailAddress());
        isExistId.setMobilePhone(companyDto.getMobilePhone());
        isExistId.setOfficePhone(companyDto.getOfficePhone());

        Company updatedCompany = companyRepository.save(isExistId);
        CompanyDto updatedCompanyDto = modelMapper.map(updatedCompany, CompanyDto.class);

        return updatedCompanyDto;
    }


}
