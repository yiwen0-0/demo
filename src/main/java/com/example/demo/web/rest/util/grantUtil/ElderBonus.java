package com.example.demo.web.rest.util.grantUtil;

import com.example.demo.domain.enumeration.HousingType;
import com.example.demo.service.dto.HouseholdDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ElderBonus implements GrantSearchEngine{
    private int MIN_ELDER_AGE = 50;

    @Override
    public List<HouseholdDTO> getValidHouseholds(List<HouseholdDTO> households) {
        return households.stream()
            .filter(household -> household.hasMemberWithAgeRange(MIN_ELDER_AGE, MAX_AGE))
            .filter(household -> household.getHousingType() == HousingType.HDB)
            .collect(Collectors.toList());
    }
}
