package com.afrikancoders.speciality.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.afrikancoders.speciality.entity.Specialitys;
import com.afrikancoders.speciality.response.SpecialityResponse;

public interface SpecialityRepository extends JpaRepository<Specialitys, Long> {
    Optional<Specialitys> findById(Long id);

    Optional<Specialitys> findBySpeciality(String Speciality);

    Optional<Specialitys> findByIdAndStateId(Long id, Long stateId);

    Optional<Specialitys> findBySpecialityAndStateId(String Speciality, Long stateId);

    List<Specialitys> findAll();

    @Query("SELECT new com.afrikancoders.speciality.response.SpecialityResponse(s.id, s.speciality) FROM Specialitys s WHERE s.state.id = 1")
    List<SpecialityResponse> findAllResponse();
}
