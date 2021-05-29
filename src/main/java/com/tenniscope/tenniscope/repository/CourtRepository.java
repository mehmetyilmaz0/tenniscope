package com.tenniscope.tenniscope.repository;

import com.tenniscope.tenniscope.entity.Court;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CourtRepository extends JpaRepository<Court, Long> {
}
