package com.aeon.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aeon.models.entities.Training;
import com.aeon.models.repos.TrainingRepo;

@Service
@Transactional
public class TrainingService {
    
    @Autowired
    private TrainingRepo trainingRepo;

    public Training save(Training training){
        return trainingRepo.save(training);
    }

    public Training findOne(Long id){
        Optional<Training> karyawan = trainingRepo.findById(id);
        if(!karyawan.isPresent()){
            return null;
        }
        return karyawan.get();
    }

    public Iterable<Training> findByNamaPengajar(String nama, Pageable pageable){
        return trainingRepo.findByNamaPengajarContains(nama, pageable);
    }
}
