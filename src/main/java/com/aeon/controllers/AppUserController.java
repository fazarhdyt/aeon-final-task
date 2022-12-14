package com.aeon.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aeon.dto.AppUserData;
import com.aeon.dto.ResponseData;
import com.aeon.models.entities.AppUser;
import com.aeon.services.AppUserService;

@RestController
@RequestMapping("/v1/users")
public class AppUserController {
    
    @Autowired
    private AppUserService appUserService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/register")
    public ResponseEntity<ResponseData<AppUser>> register(@RequestBody AppUserData userData){

        ResponseData<AppUser> response = new ResponseData<>();
        AppUser appUser = modelMapper.map(userData, AppUser.class);
        response.setPayload(appUserService.registerUser(appUser));
        response.setStatus(true);
        response.getMessages().add("User saved!");
        return ResponseEntity.ok(response);
    }
}
