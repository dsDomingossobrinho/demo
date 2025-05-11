package com.afrikancoders.typeUserIdentificator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afrikancoders.typeUserIdentificator.dto.TypeUserIdentificatorDto;
import com.afrikancoders.typeUserIdentificator.response.TypeUserIdentificatorResponse;
import com.afrikancoders.typeUserIdentificator.service.TypeUserIdentificatorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

import com.afrikancoders.security.SecurityConfig;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

import org.springframework.http.HttpStatus;
@RequestMapping("/type_user_identificators")
@RestController
@RequiredArgsConstructor
@SecurityRequirement(name= SecurityConfig.SECURITY)
public class TypeUserIdentificatorController {

    private final TypeUserIdentificatorService typeUserIdentificatorService;

    @Operation(description = "List All TypeUserIdentificators", tags = "typeUserIdentificators")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @GetMapping("/list")
    public ResponseEntity<List<TypeUserIdentificatorResponse>> list(){
        return new ResponseEntity<>(typeUserIdentificatorService.getAllTypeUserIdentificators(), HttpStatus.OK);
    }

    @Operation(description = "List TypeUserIdentificators By ID", tags = "typeUserIdentificators")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @GetMapping("/{id}")
    public ResponseEntity<TypeUserIdentificatorResponse> listbyid(@PathVariable long id){
        return new ResponseEntity<>(typeUserIdentificatorService.getTypeUserIdentificatorByIdResponse(id), HttpStatus.OK);
    }


    @Operation(description = "Save New TypeUserIdentificators", tags = "typeUserIdentificators")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @PostMapping("/save")
    public ResponseEntity<TypeUserIdentificatorResponse> save(@RequestBody TypeUserIdentificatorDto typeUserIdentificator){
        return new ResponseEntity<>(typeUserIdentificatorService.saveTypeUserIdentificator(typeUserIdentificator), HttpStatus.OK);
    }

    @Operation(description = "Update TypeUserIdentificators", tags = "typeUserIdentificator")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @PutMapping("/update/{id}")
    public ResponseEntity<TypeUserIdentificatorResponse> update(@PathVariable long id,@RequestBody TypeUserIdentificatorDto typeUserIdentificator){
        return new ResponseEntity<>(typeUserIdentificatorService.updateTypeUserIdentificator(id, typeUserIdentificator), HttpStatus.OK);
    }

    @Operation(description = "Delete TypeUserIdentificators", tags = "typeUserIdentificators")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        typeUserIdentificatorService.deleteTypeUserIdentificator(id);
        return new ResponseEntity<>("TypeUserIdentificator deleted successfully",HttpStatus.OK);
    }
    
}
