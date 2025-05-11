package com.afrikancoders.speciality.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.afrikancoders.speciality.dto.SpecialityDto;
import com.afrikancoders.speciality.entity.Specialitys;
import com.afrikancoders.speciality.repository.SpecialityRepository;
import com.afrikancoders.speciality.response.SpecialityResponse;
import com.afrikancoders.state.service.StatusService;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SpecialityServiceImpl implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    private final StatusService statusService;

    /*@PostConstruct
    public void migration() {
        if (specialityRepository.count() == 0) {
            String[] array = {
                "ADMIN",
                "SECRETARY",
                "FURNISHER",
                "DISTRIBUTOR",
                "COLLABORATOR",
                "COMPANY"
            };

            for (int i = 0; i < array.length; i++) {
                Specialitys speciality = new Specialitys();
                speciality.setSpeciality(array[i]);
                specialityRepository.save(speciality);
            }
        }
    }
    */
    @Override
    public SpecialityResponse saveSpeciality(SpecialityDto specialityDto) {
        Specialitys speciality = new Specialitys();
        speciality.setSpeciality(specialityDto.speciality());
        speciality.setState(statusService.getStateById(1L));
        specialityRepository.save(speciality);
        return new SpecialityResponse(speciality.getId(),speciality.getSpeciality());
    }

    @Override
    public SpecialityResponse updateSpeciality(Long id, SpecialityDto SpecialityDto) {
        Specialitys speciality = this.getSpecialityById(id);
        speciality.setSpeciality(SpecialityDto.speciality());
        specialityRepository.save(speciality);
        return new SpecialityResponse(speciality.getId(), speciality.getSpeciality());
    }

    @Override
    public List<SpecialityResponse> getAllSpecialitys() {
        return specialityRepository.findAllResponse();
    }

    @Override
    public Specialitys getSpecialityById(Long id) {
        return specialityRepository.findByIdAndStateId(id, 1L)
            .orElseThrow(() -> new EntityNotFoundException("Specialitys with ID " + id + " not found."));
    }

    @Override
    public Specialitys getSpecialityBySpeciality(String Speciality) {
        return specialityRepository.findBySpeciality(Speciality)
        .orElseThrow(() -> new EntityNotFoundException("Specialitys " + Speciality + " not found."));
    }

    @Override
    public SpecialityResponse getSpecialityByIdResponse(Long id) {
        Specialitys speciality = this.getSpecialityById(id);
        return new SpecialityResponse(speciality.getId(), speciality.getSpeciality());
    }

    
    @Override
    public void deleteSpeciality(Long id) {
        Specialitys speciality = this.getSpecialityById(id);
        speciality.setState(statusService.getStateById(3L));
        specialityRepository.save(speciality);
    }
    
}
