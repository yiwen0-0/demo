package com.example.demo.web.rest.util.grantUtil;

import com.example.demo.service.dto.HouseholdDTO;

import java.util.List;

public interface GrantSearchEngine {
    public static final int MIN_AGE = -1;
    public static final int MAX_AGE = Integer.MAX_VALUE;

    default public List<HouseholdDTO> getValidHouseholds(List<HouseholdDTO> households) {
        return households;
    };
}
