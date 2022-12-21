package com.aeon.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aeon.models.entities.DetailKaryawan;
import com.aeon.models.repos.DetailKaryawanRepo;

@Service
@Transactional
public class DetailKaryawanService {
    
    @Autowired
    private DetailKaryawanRepo detailKaryawanRepo;

    public DetailKaryawan save(DetailKaryawan detailKaryawan){
        return detailKaryawanRepo.save(detailKaryawan);
    }
}
