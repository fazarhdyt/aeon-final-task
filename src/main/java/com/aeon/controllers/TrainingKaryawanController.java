package com.aeon.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aeon.dto.ResponseData;
import com.aeon.dto.SearchData;
import com.aeon.models.entities.KaryawanTraining;
import com.aeon.models.repos.TrainingKaryawanRepo;
import com.aeon.models.repos.TrainingRepo;
import com.aeon.services.TrainingKaryawanService;

@RestController
@RequestMapping("/v1/training-karyawan")
public class TrainingKaryawanController {
    
    @Autowired
    private TrainingKaryawanService trainingKaryawanService;

    @Autowired
    private TrainingKaryawanRepo trainingKaryawanRepo;

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

    // @GetMapping("/list")
    // public Iterable<KaryawanTraining> findAll(){
    //     return trainingKaryawanService.findAll();
    // }

    @GetMapping("/list")
    public ResponseEntity<Map> listByNamas(
        @RequestParam() Integer page,
        @RequestParam() Integer size, 
        @RequestParam(required = false) String namaKaryawan) {
        Map map = new HashMap();
        Page<KaryawanTraining> list = null;
        Pageable show_data = PageRequest.of(page, size, Sort.by("id").descending());//batasin roq


        if ( namaKaryawan != null ) {
            list = trainingKaryawanRepo.findByKaryawanNamaLike("%" + namaKaryawan + "%", show_data);
        } else {
            list = trainingKaryawanRepo.getAllData(show_data);
        }

        map.put("data", list);
        map.put("message", "Sukses");
        map.put("status", "200");
        return new ResponseEntity<Map>(map, new HttpHeaders(), HttpStatus.OK);
        }
}
