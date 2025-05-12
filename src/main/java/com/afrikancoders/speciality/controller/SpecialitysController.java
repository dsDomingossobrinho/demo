package com.afrikancoders.speciality.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afrikancoders.speciality.dto.SpecialityDto;
import com.afrikancoders.speciality.response.SpecialityResponse;
import com.afrikancoders.speciality.service.SpecialityService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

import com.afrikancoders.security.SecurityConfig;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

import org.springframework.http.HttpStatus;
@RequestMapping("/specialitys")
@RestController
@RequiredArgsConstructor
@SecurityRequirement(name= SecurityConfig.SECURITY)
public class SpecialitysController {

    private final SpecialityService specialityService;

    @Operation(description = "List All Specialitys", tags = "Specialitys")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @GetMapping("/list")
    public ResponseEntity<List<SpecialityResponse>> list(){
        return new ResponseEntity<>(specialityService.getAllSpecialitys(), HttpStatus.OK);
    }

    @Operation(description = "List Specialitys By ID", tags = "Specialitys")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @GetMapping("/{id}")
    public ResponseEntity<SpecialityResponse> listbyid(@PathVariable long id){
        return new ResponseEntity<>(specialityService.getSpecialityByIdResponse(id), HttpStatus.OK);
    }


    @Operation(description = "Save New Specialitys", tags = "Specialitys")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @PostMapping("/save")
    public ResponseEntity<SpecialityResponse> save(@RequestBody SpecialityDto specialitys){
        return new ResponseEntity<>(specialityService.saveSpeciality(specialitys), HttpStatus.OK);
    }

    @Operation(description = "Update Specialitys", tags = "Specialitys")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @PutMapping("/update/{id}")
    public ResponseEntity<SpecialityResponse> update(@PathVariable long id,@RequestBody SpecialityDto specialitys){
        return new ResponseEntity<>(specialityService.updateSpeciality(id, specialitys), HttpStatus.OK);
    }

    @Operation(description = "Delete Specialitys", tags = "Specialitys")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        specialityService.deleteSpeciality(id);
        return new ResponseEntity<>("Specialitys deleted successfully",HttpStatus.OK);
    }
    
}
