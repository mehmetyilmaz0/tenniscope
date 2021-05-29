package com.tenniscope.tenniscope.api;

import com.tenniscope.tenniscope.dto.CourtDto;
import com.tenniscope.tenniscope.service.impl.CourtServiceImpl;
import com.tenniscope.tenniscope.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(ApiPaths.CourtCtrl.CTRL)
public class CourtController {
    
    private final CourtServiceImpl courtServiceImpl;

    public CourtController(CourtServiceImpl courtServiceImpl) {
        this.courtServiceImpl = courtServiceImpl;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourtDto> getById(@PathVariable(value = "id", required = true) Long id) {
        CourtDto courtDto = courtServiceImpl.getById(id);
        return ResponseEntity.ok(courtDto);
    }

    @PostMapping("")
    public ResponseEntity<CourtDto> create(@Valid @RequestBody CourtDto courtDto) {
        CourtDto createdCourtDto = courtServiceImpl.save(courtDto);
        return ResponseEntity.ok(createdCourtDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourtDto> update (@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody CourtDto courtDto) {
        CourtDto updatedCourtDto = courtServiceImpl.update(id, courtDto);
        return ResponseEntity.ok(updatedCourtDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete (@PathVariable(value = "id", required = true) Long id) {
        Boolean isDelete = courtServiceImpl.delete(id);
        return ResponseEntity.ok(isDelete);
    }
    
}
