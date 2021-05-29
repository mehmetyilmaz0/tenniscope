package com.tenniscope.tenniscope.service.impl;

import com.tenniscope.tenniscope.dto.CourtDto;
import com.tenniscope.tenniscope.entity.Company;
import com.tenniscope.tenniscope.entity.Court;
import com.tenniscope.tenniscope.repository.CourtRepository;
import com.tenniscope.tenniscope.service.CourtService;
import com.tenniscope.tenniscope.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CourtServiceImpl implements CourtService {

    private final CourtRepository courtRepository;
    private final ModelMapper modelMapper;

    public CourtServiceImpl(CourtRepository courtRepository, ModelMapper modelMapper) {
        this.courtRepository = courtRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public CourtDto save(CourtDto courtDto) {

        if (courtDto.getName() == null || courtDto.getName().equals("")) {
            throw new IllegalArgumentException("Court name cannot be null or empty");
        }

        Court court = modelMapper.map(courtDto, Court.class);
        court = courtRepository.save(court);
        return modelMapper.map(court, CourtDto.class);
    }

    @Override
    public CourtDto getById(Long id) {
        Court court = courtRepository.getById(id);
        return modelMapper.map(court, CourtDto.class);
    }

    @Override
    public TPage<CourtDto> getAllPageable(Pageable pageable) {
        Page<Court> courtPage = courtRepository.findAll(pageable);
        CourtDto[] courtDtos = modelMapper.map(courtPage.getContent(), CourtDto[].class);
        TPage<CourtDto> courtDtoTPage = new TPage<CourtDto>();
        courtDtoTPage.setStat(courtPage, Arrays.asList(courtDtos));
        return courtDtoTPage;
    }

    @Override
    public Boolean delete(CourtDto courtDto) {
        Court court = modelMapper.map(courtDto, Court.class);
        courtRepository.delete(court);
        return true;
    }

    @Override
    public Boolean delete(Long id) {
        Court isExistId = courtRepository.getById(id);
        if (isExistId == null) {
            throw new IllegalArgumentException("Court id not found");
        }
        courtRepository.deleteById(id);
        return true;
    }

    @Override
    public CourtDto update(Long id, CourtDto courtDto) {
        Court isExistId = courtRepository.getById(id);
        if (isExistId == null)
            throw new IllegalArgumentException("Court id does not exist");

        isExistId.setName(courtDto.getName());
        isExistId.setDescription(courtDto.getDescription());
        isExistId.setCourtType(courtDto.getCourtType());

        Company company = modelMapper.map(courtDto.getCompany(), Company.class);
        isExistId.setCompany(company);

        Court updatedCourt = courtRepository.save(isExistId);
        CourtDto updatedCourtDto = modelMapper.map(updatedCourt, CourtDto.class);

        return updatedCourtDto;
    }
}
