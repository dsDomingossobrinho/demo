package com.afrikancoders.typeNotification.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afrikancoders.typeNotification.dto.TypeNotificationDto;
import com.afrikancoders.typeNotification.response.TypeNotificationResponse;
import com.afrikancoders.typeNotification.service.TypeNotificationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

import com.afrikancoders.security.SecurityConfig;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

import org.springframework.http.HttpStatus;
@RequestMapping("/type_notifications")
@RestController
@RequiredArgsConstructor
@SecurityRequirement(name= SecurityConfig.SECURITY)
public class TypeNotificationController {

    private final TypeNotificationService TypeNotificationService;

    @Operation(description = "List All TypeNotifications", tags = "typeNotifications")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @GetMapping("/list")
    public ResponseEntity<List<TypeNotificationResponse>> list(){
        return new ResponseEntity<>(TypeNotificationService.getAllTypeNotifications(), HttpStatus.OK);
    }

    @Operation(description = "List TypeNotifications By ID", tags = "typeNotifications")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @GetMapping("/{id}")
    public ResponseEntity<TypeNotificationResponse> listbyid(@PathVariable long id){
        return new ResponseEntity<>(TypeNotificationService.getTypeNotificationByIdResponse(id), HttpStatus.OK);
    }


    @Operation(description = "Save New TypeNotifications", tags = "typeNotifications")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @PostMapping("/save")
    public ResponseEntity<TypeNotificationResponse> save(@RequestBody TypeNotificationDto typeNotification){
        return new ResponseEntity<>(TypeNotificationService.saveTypeNotification(typeNotification), HttpStatus.OK);
    }

    @Operation(description = "Update TypeNotifications", tags = "typeNotification")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @PutMapping("/update/{id}")
    public ResponseEntity<TypeNotificationResponse> update(@PathVariable long id,@RequestBody TypeNotificationDto typeNotification){
        return new ResponseEntity<>(TypeNotificationService.updateTypeNotification(id, typeNotification), HttpStatus.OK);
    }

    @Operation(description = "Delete TypeNotifications", tags = "typeNotifications")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "Success"))
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        TypeNotificationService.deleteTypeNotification(id);
        return new ResponseEntity<>("TypeNotification deleted successfully",HttpStatus.OK);
    }
    
}
