package com.aeon.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aeon.dto.ResponseData;
import com.aeon.models.entities.DetailKaryawan;
import com.aeon.services.DetailKaryawanService;

@RestController
@RequestMapping("/v1/detailKaryawan")

public class DetailKaryawanController {
    
    @Autowired
    private DetailKaryawanService detailKaryawanService;

    @PostMapping
    public ResponseEntity<ResponseData<DetailKaryawan>> create(@Valid @RequestBody DetailKaryawan detailKaryawan, Errors errors){
        
        ResponseData<DetailKaryawan> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(detailKaryawanService.save(detailKaryawan));
        return ResponseEntity.ok(responseData);
    }
}
