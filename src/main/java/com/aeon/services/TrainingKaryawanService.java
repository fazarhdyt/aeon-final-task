package com.aeon.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aeon.models.entities.KaryawanTraining;
import com.aeon.models.repos.TrainingKaryawanRepo;

@Service
@Transactional
public class TrainingKaryawanService {
    
    @Autowired
    private TrainingKaryawanRepo trainingKaryawanRepo;

    public KaryawanTraining save(KaryawanTraining karyawanTraining){
        return trainingKaryawanRepo.save(karyawanTraining);
    }

    public Iterable<KaryawanTraining> findAll(){
        return trainingKaryawanRepo.findAll();
    }

    // public Iterable<KaryawanTraining> findByNamaAndTema(String nama, String tema, Pageable pageable){
    //     return trainingKaryawanRepo.findByNamaPengajarAndTemaContains(nama, tema, pageable);
    // }
}
