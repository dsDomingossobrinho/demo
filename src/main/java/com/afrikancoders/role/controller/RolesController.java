package com.afrikancoders.role.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afrikancoders.role.dto.RoleDto;
import com.afrikancoders.role.response.RoleResponse;
import com.afrikancoders.role.service.RoleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

import com.afrikancoders.security.SecurityConfig;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

import org.springframework.http.HttpStatus;
@RequestMapping("/roles")
@RestController
@RequiredArgsConstructor
@SecurityRequirement(name= SecurityConfig.SECURITY)
public class RolesController {

    private final RoleService roleService;

    @Operation(description = "List All Roles", tags = "Roles")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @GetMapping("/list")
    public ResponseEntity<List<RoleResponse>> list(){
        return new ResponseEntity<>(roleService.getAllRoles(), HttpStatus.OK);
    }

    @Operation(description = "List Roles By ID", tags = "Roles")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @GetMapping("/{id}")
    public ResponseEntity<RoleResponse> listbyid(@PathVariable long id){
        return new ResponseEntity<>(roleService.getRoleByIdResponse(id), HttpStatus.OK);
    }


    @Operation(description = "Save New Roles", tags = "Roles")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @PostMapping("/save")
    public ResponseEntity<RoleResponse> save(@RequestBody RoleDto roles){
        return new ResponseEntity<>(roleService.saveRole(roles), HttpStatus.OK);
    }

    @Operation(description = "Update Roles", tags = "Roles")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @PutMapping("/update/{id}")
    public ResponseEntity<RoleResponse> update(@PathVariable long id,@RequestBody RoleDto roles){
        return new ResponseEntity<>(roleService.updateRole(id, roles), HttpStatus.OK);
    }

    @Operation(description = "Delete Roles", tags = "Roles")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        roleService.deleteRole(id);
        return new ResponseEntity<>("Roles deleted successfully",HttpStatus.OK);
    }
    
}
