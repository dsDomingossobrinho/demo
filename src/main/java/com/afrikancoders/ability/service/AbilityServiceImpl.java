package com.afrikancoders.ability.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.afrikancoders.ability.dto.AbilityDto;
import com.afrikancoders.ability.entity.Abilitys;
import com.afrikancoders.ability.repository.AbilityRepository;
import com.afrikancoders.ability.response.AbilityResponse;
import com.afrikancoders.state.service.StatusService;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AbilityServiceImpl implements AbilityService {

    private final AbilityRepository abilityRepository;

    private final StatusService statusService;

    /*@PostConstruct
    public void migration() {
        if (abilityRepository.count() == 0) {
            String[] array = {
                "active",
                "inactive",
                "eliminated",
                "pending",
                "rejected",
                "updated",
                "expired",
                "renewed"
            };

            for (int i = 0; i < array.length; i++) {
                Abilitys ability = new Abilitys();
                ability.setAbility(array[i]);
                abilityRepository.save(ability);
            }
        }
    }*/

    @Override
    public AbilityResponse saveAbility(AbilityDto abilityDto) {
        Abilitys ability = new Abilitys();
        ability.setAbility(abilityDto.ability());
        ability.setState(statusService.getStateById(1L));
        abilityRepository.save(ability);
        return new AbilityResponse(ability.getId(),ability.getAbility());
    }

    @Override
    public AbilityResponse updateAbility(Long id, AbilityDto AbilityDto) {
        Abilitys Ability = this.getAbilityById(id);
        Ability.setAbility(AbilityDto.ability());
        abilityRepository.save(Ability);
        return new AbilityResponse(Ability.getId(), Ability.getAbility());
    }

    @Override
    public List<AbilityResponse> getAllAbilitys() {
        return abilityRepository.findAllResponse();
    }

    @Override
    public Abilitys getAbilityById(Long id) {
        return abilityRepository.findByIdAndStateId(id, 1L)
            .orElseThrow(() -> new EntityNotFoundException("Abilitys with ID " + id + " not found."));
    }

    @Override
    public Abilitys getAbilityByAbility(String Ability) {
        return abilityRepository.findByAbility(Ability)
        .orElseThrow(() -> new EntityNotFoundException("Abilitys " + Ability + " not found."));
    }

    @Override
    public AbilityResponse getAbilityByIdResponse(Long id) {
        Abilitys Ability = this.getAbilityById(id);
        return new AbilityResponse(Ability.getId(), Ability.getAbility());
    }

    
    @Override
    public void deleteAbility(Long id) {
        Abilitys ability = this.getAbilityById(id);
        ability.setState(statusService.getStateById(3L));
        abilityRepository.save(ability);
    }
    
}
