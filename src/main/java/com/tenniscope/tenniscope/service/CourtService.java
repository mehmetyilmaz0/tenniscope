package com.tenniscope.tenniscope.service;

import com.tenniscope.tenniscope.dto.CourtDto;
import com.tenniscope.tenniscope.entity.Court;
import com.tenniscope.tenniscope.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourtService {

    CourtDto save(CourtDto courtDto);

    CourtDto getById(Long id);

    TPage<CourtDto> getAllPageable (Pageable pageable);

    Boolean delete(CourtDto courtDto);

    Boolean delete(Long id);

    CourtDto update(Long id, CourtDto courtDto);

}
