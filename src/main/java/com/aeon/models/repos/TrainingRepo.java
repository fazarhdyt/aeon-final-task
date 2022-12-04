package com.aeon.models.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.aeon.models.entities.Training;

public interface TrainingRepo extends PagingAndSortingRepository<Training, Long>{
    
    Page<Training> findByNamaPengajarContains(String nama, Pageable pageable);
}
