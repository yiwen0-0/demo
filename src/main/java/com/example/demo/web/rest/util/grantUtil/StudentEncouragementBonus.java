package com.example.demo.web.rest.util.grantUtil;

import com.example.demo.service.dto.HouseholdDTO;

import java.util.List;
import java.util.stream.Collectors;

public class StudentEncouragementBonus implements GrantSearchEngine{
    private final Long MAX_HOUSEHOLD_INCOME = 150000L;
    private final int MAX_CHILD_AGE = 16;

    @Override
    public List<HouseholdDTO> getValidHouseholds(List<HouseholdDTO> households) {
        return households.stream()
            .filter(household -> household.getTotalHouseholdIncome() <= MAX_HOUSEHOLD_INCOME)
            .filter(household -> household.hasMemberWithAgeRange(MIN_AGE, MAX_CHILD_AGE))
            .collect(Collectors.toList());
    }
}
