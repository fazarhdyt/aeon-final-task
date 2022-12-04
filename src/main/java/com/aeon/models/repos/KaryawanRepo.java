package com.aeon.models.repos;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.aeon.models.entities.Karyawan;

public interface KaryawanRepo extends PagingAndSortingRepository <Karyawan, Long>{

    Page<Karyawan> findByNamaContains(String nama, Pageable pageable);
}
