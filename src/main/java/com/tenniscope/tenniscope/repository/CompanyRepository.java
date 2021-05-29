package com.tenniscope.tenniscope.repository;

import com.tenniscope.tenniscope.entity.City;
import com.tenniscope.tenniscope.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findAllByCompanyCode(String companyCode);

    List<Company> getAllByCity(City city);

    Page<Company> findAll(Pageable pageable);


}
