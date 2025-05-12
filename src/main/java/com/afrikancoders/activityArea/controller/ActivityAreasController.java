package com.afrikancoders.activityArea.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afrikancoders.activityArea.dto.ActivityAreaDto;
import com.afrikancoders.activityArea.response.ActivityAreaResponse;
import com.afrikancoders.activityArea.service.ActivityAreaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

import com.afrikancoders.security.SecurityConfig;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

import org.springframework.http.HttpStatus;
@RequestMapping("/activity_areas")
@RestController
@RequiredArgsConstructor
@SecurityRequirement(name= SecurityConfig.SECURITY)
public class ActivityAreasController {

    private final ActivityAreaService activityAreaService;

    @Operation(description = "List All ActivityAreas", tags = "ActivityAreas")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @GetMapping("/list")
    public ResponseEntity<List<ActivityAreaResponse>> list(){
        return new ResponseEntity<>(activityAreaService.getAllActivityAreas(), HttpStatus.OK);
    }

    @Operation(description = "List ActivityAreas By ID", tags = "ActivityAreas")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @GetMapping("/{id}")
    public ResponseEntity<ActivityAreaResponse> listbyid(@PathVariable long id){
        return new ResponseEntity<>(activityAreaService.getActivityAreaByIdResponse(id), HttpStatus.OK);
    }


    @Operation(description = "Save New ActivityAreas", tags = "ActivityAreas")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @PostMapping("/save")
    public ResponseEntity<ActivityAreaResponse> save(@RequestBody ActivityAreaDto activityAreas){
        return new ResponseEntity<>(activityAreaService.saveActivityArea(activityAreas), HttpStatus.OK);
    }

    @Operation(description = "Update ActivityAreas", tags = "ActivityAreas")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @PutMapping("/update/{id}")
    public ResponseEntity<ActivityAreaResponse> update(@PathVariable long id,@RequestBody ActivityAreaDto ActivityAreas){
        return new ResponseEntity<>(activityAreaService.updateActivityArea(id, ActivityAreas), HttpStatus.OK);
    }

    @Operation(description = "Delete ActivityAreas", tags = "ActivityAreas")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        activityAreaService.deleteActivityArea(id);
        return new ResponseEntity<>("ActivityAreas deleted successfully",HttpStatus.OK);
    }
    
}
