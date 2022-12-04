package com.aeon.services;

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

    public Iterable<Training> findByNamaAndTema(String nama, String tema, Pageable pageable){
        return trainingRepo.findByNamaPengajarAndTemaContains(nama, tema, pageable);
    }
}
