package com.aeon.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aeon.dto.ResponseData;
import com.aeon.dto.SearchData;
import com.aeon.models.entities.KaryawanTraining;
import com.aeon.services.TrainingKaryawanService;

@RestController
@RequestMapping("/v1/training-karyawan")
public class TrainingKaryawanController {
    
    @Autowired
    private TrainingKaryawanService trainingKaryawanService;

    @PostMapping
    public ResponseEntity<ResponseData<KaryawanTraining>> create(@Valid @RequestBody KaryawanTraining karyawanTraining, Errors errors){
        
        ResponseData<KaryawanTraining> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(trainingKaryawanService.save(karyawanTraining));
        return ResponseEntity.ok(responseData);
    }

    // @GetMapping("/list/{size}/{page}")
    // public Iterable<KaryawanTraining> findByNamaAndTema(@RequestBody SearchData searchData, @RequestBody SearchData getOtherSearchKey, @PathVariable("size") int size, @PathVariable("page") int page){

    //     Pageable pageable = PageRequest.of(page, size);
    //     return trainingKaryawanService.findByNamaAndTema(searchData.getSearchKey(), searchData.getOtherSearchKey(), pageable);
    // }
}
