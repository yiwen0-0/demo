package com.example.demo.service.dto;

import java.io.Serializable;
import java.util.Objects;
import com.example.demo.domain.enumeration.HousingType;

/**
 * A DTO for the {@link com.example.demo.domain.Household} entity.
 */
public class HouseholdDTO implements Serializable {
    
    private Long id;

    private HousingType housingType;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HousingType getHousingType() {
        return housingType;
    }

    public void setHousingType(HousingType housingType) {
        this.housingType = housingType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        HouseholdDTO householdDTO = (HouseholdDTO) o;
        if (householdDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), householdDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "HouseholdDTO{" +
            "id=" + getId() +
            ", housingType='" + getHousingType() + "'" +
            "}";
    }
}