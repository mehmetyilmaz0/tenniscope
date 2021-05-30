package com.tenniscope.tenniscope.api;

import com.tenniscope.tenniscope.dto.CourtDto;
import com.tenniscope.tenniscope.service.impl.CourtServiceImpl;
import com.tenniscope.tenniscope.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(ApiPaths.CourtCtrl.CTRL)
@Api(description = "Company APIs")
@Slf4j
public class CourtController {
    
    private final CourtServiceImpl courtServiceImpl;

    public CourtController(CourtServiceImpl courtServiceImpl) {
        this.courtServiceImpl = courtServiceImpl;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation", response = CourtDto.class)
    public ResponseEntity<CourtDto> getById(@PathVariable(value = "id", required = true) Long id) {
        log.info("CourtController -> getById");
        log.debug("CourtController -> getById -> Param : " + id);
        CourtDto courtDto = courtServiceImpl.getById(id);
        return ResponseEntity.ok(courtDto);
    }

    @PostMapping("")
    @ApiOperation(value = "Create Operation", response = CourtDto.class)
    public ResponseEntity<CourtDto> create(@Valid @RequestBody CourtDto courtDto) {
        log.info("CourtController -> create");
        log.debug("CourtController -> create -> Param : " + courtDto);
        CourtDto createdCourtDto = courtServiceImpl.save(courtDto);
        return ResponseEntity.ok(createdCourtDto);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = CourtDto.class)
    public ResponseEntity<CourtDto> update (@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody CourtDto courtDto) {
        log.info("CourtController -> update");
        log.debug("CourtController -> update -> Param : " + id + " - " + courtDto);
        CourtDto updatedCourtDto = courtServiceImpl.update(id, courtDto);
        return ResponseEntity.ok(updatedCourtDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation", response = Boolean.class)
    public ResponseEntity<Boolean> delete (@PathVariable(value = "id", required = true) Long id) {
        log.info("CourtController -> delete");
        log.debug("CourtController -> delete -> Param : " + id);
        Boolean isDelete = courtServiceImpl.delete(id);
        return ResponseEntity.ok(isDelete);
    }
    
}
