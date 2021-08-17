package com.example.demo.web.rest.util.grantUtil;

import com.example.demo.service.dto.HouseholdDTO;

import java.util.List;
import java.util.stream.Collectors;

public class YOLOGSTGrant implements GrantSearchEngine{
    private Long MAX_HOUSEHOLD_INCOME = 100000L;

    @Override
    public List<HouseholdDTO> getValidHouseholds(List<HouseholdDTO> households) {
        return households.stream()
            .filter(household -> household.getTotalHouseholdIncome() <= MAX_HOUSEHOLD_INCOME)
            .collect(Collectors.toList());
    }
}
