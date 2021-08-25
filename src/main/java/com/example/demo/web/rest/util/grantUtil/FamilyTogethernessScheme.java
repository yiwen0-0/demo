package com.example.demo.web.rest.util.grantUtil;

import com.example.demo.service.dto.HouseholdDTO;

import java.util.List;
import java.util.stream.Collectors;

public class FamilyTogethernessScheme implements GrantSearchEngine{
    private final int MAX_CHILD_AGE = 18;

    @Override
    public List<HouseholdDTO> getValidHouseholds(List<HouseholdDTO> households) {
        return households.stream()
            .filter(household -> household.hasMarriedCouple())
            .filter(household -> household.hasMemberWithAgeRange(MIN_AGE, MAX_CHILD_AGE))
            .collect(Collectors.toList());
    }
}
