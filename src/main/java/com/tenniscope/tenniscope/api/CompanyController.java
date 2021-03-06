package com.tenniscope.tenniscope.api;

import com.tenniscope.tenniscope.dto.CompanyDto;
import com.tenniscope.tenniscope.dto.CourtDto;
import com.tenniscope.tenniscope.service.impl.CompanyServiceImpl;
import com.tenniscope.tenniscope.util.ApiPaths;
import com.tenniscope.tenniscope.util.TPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.CompanyCtrl.CTRL)
@Api(description = "Company APIs")
@Slf4j
public class CompanyController {

    private final CompanyServiceImpl companyServiceImpl;

    public CompanyController(CompanyServiceImpl companyServiceImpl) {
        this.companyServiceImpl = companyServiceImpl;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation", response = CompanyDto.class)
    public ResponseEntity<CompanyDto> getById(@PathVariable(value = "id", required = true) Long id) {
        log.info("CompanyController -> getById");
        log.debug("CompanyController -> getById -> Param : " + id);
        CompanyDto companyDto = companyServiceImpl.getById(id);
        return ResponseEntity.ok(companyDto);
    }

    @PostMapping("")
    @ApiOperation(value = "Create Operation", response = CompanyDto.class)
    public ResponseEntity<CompanyDto> create(@Valid @RequestBody CompanyDto companyDto) {
        log.info("CompanyController -> create");
        log.debug("CompanyController -> create -> Param : " + companyDto);
        CompanyDto createdCompanyDto = companyServiceImpl.save(companyDto);
        return ResponseEntity.ok(createdCompanyDto);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = CompanyDto.class)
    public ResponseEntity<CompanyDto> update (@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody CompanyDto companyDto) {
        log.info("CompanyController -> update");
        log.debug("CompanyController -> update -> Param : " + id + " - " + companyDto);
        CompanyDto updatedCompanyDto = companyServiceImpl.update(id, companyDto);
        return ResponseEntity.ok(updatedCompanyDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation", response = Boolean.class)
    public ResponseEntity<Boolean> delete (@PathVariable(value = "id", required = true) Long id) {
        log.info("CompanyController -> delete");
        log.debug("CompanyController -> delete -> Param : " + id);
        Boolean isDelete = companyServiceImpl.delete(id);
        return ResponseEntity.ok(isDelete);
    }

    @GetMapping("/pagination")
    @ApiOperation(value = "Get All Pagination Operation", response = CompanyDto.class)
    public ResponseEntity<TPage<CompanyDto>> getAllByPagination(Pageable pageable) {
        log.info("CompanyController -> getAllByPagination");
        log.debug("CompanyController -> getAllByPagination -> Param : " + pageable);
        TPage<CompanyDto> companyDtoTPage = companyServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(companyDtoTPage);
    }

}

/**
 * ResponseEntity : bizim api metodlarimizin disarida ortak bir imzaya sahip olabilmesi icin
 * ve HttpEntity s??n??f??na ek olarak builder tasar??m desenini kullanarak iste??e
 * yan??t olarak header bilgisi, HTTP durum kodu gibi bilgileri eklemeyi sa??lar.
 *
 * @RequestBody : annotasyonu ile POST veya PUT request'leri handle edilir. Genelde JSON veya XML format??nda
 * bir request'i nesneye d??n????t??rmek i??in kullan??l??r.
 *
 * @Api : swagger da dok??mantasyon olusturabilmek icin bu controller in bir api oldugunu belirtiyoruz
 *
 */
