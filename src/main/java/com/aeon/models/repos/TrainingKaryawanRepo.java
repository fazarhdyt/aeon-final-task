package com.aeon.models.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.aeon.models.entities.KaryawanTraining;

public interface TrainingKaryawanRepo extends PagingAndSortingRepository<KaryawanTraining, Long>{

    @Query("select c from KaryawanTraining c")
    public Page<KaryawanTraining> getAllData(Pageable pageable);

    public Page<KaryawanTraining> findByKaryawanNamaLike(String namaKaryawan , Pageable pageable);
}
