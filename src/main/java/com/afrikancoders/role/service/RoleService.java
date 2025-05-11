package com.afrikancoders.role.service;

import java.util.List;

import com.afrikancoders.role.dto.RoleDto;
import com.afrikancoders.role.entity.Roles;
import com.afrikancoders.role.response.RoleResponse;

public interface RoleService {

    RoleResponse saveRole(RoleDto roleDto);

    RoleResponse updateRole(Long id, RoleDto roleDto);

    void deleteRole(Long id);    

    List<RoleResponse> getAllRoles();

    Roles getRoleById(Long id);

    RoleResponse getRoleByIdResponse(Long id);

    Roles getRoleByRole(String role);
    
}
