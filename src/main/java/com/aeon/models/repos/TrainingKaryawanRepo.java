package com.aeon.models.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.aeon.models.entities.KaryawanTraining;

public interface TrainingKaryawanRepo extends PagingAndSortingRepository<KaryawanTraining, Long>{

    // Page<KaryawanTraining> findByNamaPengajarAndTemaContains(String nama, String tema, Pageable pageable);
}
