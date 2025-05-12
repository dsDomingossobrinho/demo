package com.afrikancoders.state.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afrikancoders.state.dto.StateDto;
import com.afrikancoders.state.response.StateResponse;
import com.afrikancoders.state.service.StatusService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

import com.afrikancoders.security.SecurityConfig;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

import org.springframework.http.HttpStatus;
@RequestMapping("/status")
@RestController
@RequiredArgsConstructor
@SecurityRequirement(name= SecurityConfig.SECURITY)
public class StatusController {

    private final StatusService statusService;

    @Operation(description = "List All Status", tags = "Status")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @GetMapping("/list")
    public ResponseEntity<List<StateResponse>> list(){
        return new ResponseEntity<>(statusService.getAllStates(), HttpStatus.OK);
    }

    @Operation(description = "List Status By ID", tags = "Status")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @GetMapping("/{id}")
    public ResponseEntity<StateResponse> listbyid(@PathVariable long id){
        return new ResponseEntity<>(statusService.getStateByIdResponse(id), HttpStatus.OK);
    }


    @Operation(description = "Save New Status", tags = "Status")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @PostMapping("/save")
    public ResponseEntity<StateResponse> save(@RequestBody StateDto state){
        return new ResponseEntity<>(statusService.saveState(state), HttpStatus.OK);
    }

    @Operation(description = "Update Status", tags = "Status")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @PutMapping("/update/{id}")
    public ResponseEntity<StateResponse> update(@PathVariable long id,@RequestBody StateDto state){
        return new ResponseEntity<>(statusService.updateState(id, state), HttpStatus.OK);
    }

    /*@Operation(description = "Update Status", tags = "Status")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        return statusService.delete(id);
    }*/
    
}
