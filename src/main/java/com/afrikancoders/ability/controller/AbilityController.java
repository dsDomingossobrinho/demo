package com.afrikancoders.ability.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afrikancoders.ability.dto.AbilityDto;
import com.afrikancoders.ability.response.AbilityResponse;
import com.afrikancoders.ability.service.AbilityService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

import com.afrikancoders.security.SecurityConfig;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

import org.springframework.http.HttpStatus;
@RequestMapping("/abilitys")
@RestController
@RequiredArgsConstructor
@SecurityRequirement(name= SecurityConfig.SECURITY)
public class AbilityController {

    private final AbilityService abilityService;

    @Operation(description = "List All Abilitys", tags = "abilitys")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @GetMapping("/list")
    public ResponseEntity<List<AbilityResponse>> list(){
        return new ResponseEntity<>(abilityService.getAllAbilitys(), HttpStatus.OK);
    }

    @Operation(description = "List Abilitys By ID", tags = "abilitys")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @GetMapping("/{id}")
    public ResponseEntity<AbilityResponse> listbyid(@PathVariable long id){
        return new ResponseEntity<>(abilityService.getAbilityByIdResponse(id), HttpStatus.OK);
    }


    @Operation(description = "Save New Abilitys", tags = "abilitys")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @PostMapping("/save")
    public ResponseEntity<AbilityResponse> save(@RequestBody AbilityDto Ability){
        return new ResponseEntity<>(abilityService.saveAbility(Ability), HttpStatus.OK);
    }

    @Operation(description = "Update Abilitys", tags = "ability")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @PutMapping("/update/{id}")
    public ResponseEntity<AbilityResponse> update(@PathVariable long id,@RequestBody AbilityDto Ability){
        return new ResponseEntity<>(abilityService.updateAbility(id, Ability), HttpStatus.OK);
    }

    @Operation(description = "Delete Abilitys", tags = "abilitys")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        abilityService.deleteAbility(id);
        return new ResponseEntity<>("Ability deleted successfully",HttpStatus.OK);
    }
    
}
