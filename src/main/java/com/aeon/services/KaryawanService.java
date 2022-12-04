package com.aeon.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aeon.models.entities.Karyawan;
import com.aeon.models.repos.KaryawanRepo;

@Service
@Transactional

public class KaryawanService{

    @Autowired
    private KaryawanRepo karyawanRepo;

    public Karyawan save(Karyawan karyawan){
        return karyawanRepo.save(karyawan);
    }

    public Karyawan findOne(Long id){
        Optional<Karyawan> karyawan = karyawanRepo.findById(id);
        if(!karyawan.isPresent()){
            return null;
        }
        return karyawan.get();
    }

    public Iterable<Karyawan> findByNama(String nama, Pageable pageable){
        return karyawanRepo.findByNamaContains(nama, pageable);
    }
}