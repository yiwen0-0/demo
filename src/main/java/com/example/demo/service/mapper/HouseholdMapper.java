package com.example.demo.service.mapper;


import com.example.demo.domain.*;
import com.example.demo.service.dto.HouseholdDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Household} and its DTO {@link HouseholdDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface HouseholdMapper extends EntityMapper<HouseholdDTO, Household> {


    @Mapping(target = "people", ignore = true)
    @Mapping(target = "removePerson", ignore = true)
    Household toEntity(HouseholdDTO householdDTO);

    default Household fromId(Long id) {
        if (id == null) {
            return null;
        }
        Household household = new Household();
        household.setId(id);
        return household;
    }
}
