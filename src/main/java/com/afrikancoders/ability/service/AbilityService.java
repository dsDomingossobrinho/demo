package com.afrikancoders.ability.service;

import java.util.List;

import com.afrikancoders.ability.dto.AbilityDto;
import com.afrikancoders.ability.entity.Abilitys;
import com.afrikancoders.ability.response.AbilityResponse;

public interface AbilityService {

    AbilityResponse saveAbility(AbilityDto abilityDto);

    AbilityResponse updateAbility(Long id, AbilityDto abilityDto);

    void deleteAbility(Long id);    

    List<AbilityResponse> getAllAbilitys();

    Abilitys getAbilityById(Long id);

    AbilityResponse getAbilityByIdResponse(Long id);

    Abilitys getAbilityByAbility(String Ability);
    
}
