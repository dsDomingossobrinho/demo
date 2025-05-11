package com.afrikancoders.speciality.service;

import java.util.List;

import com.afrikancoders.speciality.dto.SpecialityDto;
import com.afrikancoders.speciality.entity.Specialitys;
import com.afrikancoders.speciality.response.SpecialityResponse;

public interface SpecialityService {

    SpecialityResponse saveSpeciality(SpecialityDto specialityDto);

    SpecialityResponse updateSpeciality(Long id, SpecialityDto specialityDto);

    void deleteSpeciality(Long id);    

    List<SpecialityResponse> getAllSpecialitys();

    Specialitys getSpecialityById(Long id);

    SpecialityResponse getSpecialityByIdResponse(Long id);

    Specialitys getSpecialityBySpeciality(String speciality);
    
}
