package com.aeon.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aeon.dto.ResponseData;
import com.aeon.dto.SearchData;
import com.aeon.models.entities.Karyawan;
import com.aeon.services.KaryawanService;

@RestController
@RequestMapping("/v1/karyawan")

public class KaryawanController {
    
    @Autowired
    private KaryawanService karyawanService;

    @PostMapping
    public ResponseEntity<ResponseData<Karyawan>> create(@Valid @RequestBody Karyawan karyawan, Errors errors){
        
        ResponseData<Karyawan> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(karyawanService.save(karyawan));
        return ResponseEntity.ok(responseData);
    }
    
    @GetMapping("/{id}")
    public Karyawan findOne(@PathVariable("id") Long id){
        return karyawanService.findOne(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Karyawan>> update(@Valid @RequestBody Karyawan karyawan, Errors errors){
        
        ResponseData<Karyawan> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(karyawanService.save(karyawan));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping("/list/{size}/{page}")
    public Iterable<Karyawan> findByName(@RequestBody SearchData searchData, @PathVariable("size") int size, @PathVariable("page") int page){

        Pageable pageable = PageRequest.of(page, size);
        return karyawanService.findByNama(searchData.getSearchKey(), pageable);
    }
}
