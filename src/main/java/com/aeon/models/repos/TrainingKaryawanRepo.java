package com.aeon.models.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.aeon.models.entities.KaryawanTraining;

public interface TrainingKaryawanRepo extends PagingAndSortingRepository<KaryawanTraining, Long>{
    
}
