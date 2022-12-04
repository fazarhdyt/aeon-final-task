package com.aeon.models.repos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.aeon.models.entities.DetailKaryawan;

public interface DetailKaryawanRepo extends PagingAndSortingRepository<DetailKaryawan, Long> {
    
}
