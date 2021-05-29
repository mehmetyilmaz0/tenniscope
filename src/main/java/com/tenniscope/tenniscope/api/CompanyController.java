package com.tenniscope.tenniscope.api;

import com.tenniscope.tenniscope.dto.CompanyDto;
import com.tenniscope.tenniscope.service.impl.CompanyServiceImpl;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyServiceImpl companyServiceImpl;

    public CompanyController(CompanyServiceImpl companyServiceImpl) {
        this.companyServiceImpl = companyServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDto> getById(@PathVariable(value = "id", required = true) Long id) {
        CompanyDto companyDto = companyServiceImpl.getById(id);
        return ResponseEntity.ok(companyDto);
    }

    @PostMapping("")
    public ResponseEntity<CompanyDto> create(@Valid @RequestBody CompanyDto companyDto) {
        CompanyDto createdCompanyDto = companyServiceImpl.save(companyDto);
        return ResponseEntity.ok(createdCompanyDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyDto> update (@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody CompanyDto companyDto) {
        CompanyDto updatedCompanyDto = companyServiceImpl.update(id, companyDto);
        return ResponseEntity.ok(updatedCompanyDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete (@PathVariable(value = "id", required = true) Long id) {
        Boolean isDelete = companyServiceImpl.delete(id);
        return ResponseEntity.ok(isDelete);
    }

}

/**
 * ResponseEntity : bizim api metodlarimizin disarida ortak bir imzaya sahip olabilmesi icin
 * ve HttpEntity sınıfına ek olarak builder tasarım desenini kullanarak isteğe
 * yanıt olarak header bilgisi, HTTP durum kodu gibi bilgileri eklemeyi sağlar.
 *
 * @RequestBody : annotasyonu ile POST veya PUT request'leri handle edilir. Genelde JSON veya XML formatında
 * bir request'i nesneye dönüştürmek için kullanılır.
 */
