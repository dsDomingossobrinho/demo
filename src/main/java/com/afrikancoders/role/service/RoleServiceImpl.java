package com.afrikancoders.role.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.afrikancoders.role.dto.RoleDto;
import com.afrikancoders.role.entity.Roles;
import com.afrikancoders.role.repository.RoleRepository;
import com.afrikancoders.role.response.RoleResponse;
import com.afrikancoders.state.service.StatusService;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository RoleRepository;

    private final StatusService statusService;

    @PostConstruct
    public void migration() {
        if (RoleRepository.count() == 0) {
            String[] array = {
                "ADMIN",
                "SECRETARY",
                "FURNISHER",
                "DISTRIBUTOR",
                "COLLABORATOR",
                "COMPANY"
            };

            for (int i = 0; i < array.length; i++) {
                Roles Role = new Roles();
                Role.setRole(array[i]);
                RoleRepository.save(Role);
            }
        }
    }

    @Override
    public RoleResponse saveRole(RoleDto roleDto) {
        Roles role = new Roles();
        role.setRole(roleDto.role());
        role.setState(statusService.getStateById(1L));
        RoleRepository.save(role);
        return new RoleResponse(role.getId(),role.getRole());
    }

    @Override
    public RoleResponse updateRole(Long id, RoleDto roleDto) {
        Roles role = this.getRoleById(id);
        role.setRole(roleDto.role());
        RoleRepository.save(role);
        return new RoleResponse(role.getId(), role.getRole());
    }

    @Override
    public List<RoleResponse> getAllRoles() {
        return RoleRepository.findAllResponse();
    }

    @Override
    public Roles getRoleById(Long id) {
        return RoleRepository.findByIdAndStateId(id, 1L)
            .orElseThrow(() -> new EntityNotFoundException("Roles with ID " + id + " not found."));
    }

    @Override
    public Roles getRoleByRole(String role) {
        return RoleRepository.findByRole(role)
        .orElseThrow(() -> new EntityNotFoundException("Roles " + role + " not found."));
    }

    @Override
    public RoleResponse getRoleByIdResponse(Long id) {
        Roles role = this.getRoleById(id);
        return new RoleResponse(role.getId(), role.getRole());
    }

    
    @Override
    public void deleteRole(Long id) {
        Roles role = this.getRoleById(id);
        role.setState(statusService.getStateById(3L));
        RoleRepository.save(role);
    }
    
}
