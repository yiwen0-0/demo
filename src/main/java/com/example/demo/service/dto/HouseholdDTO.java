package com.example.demo.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.LongAccumulator;

import com.example.demo.domain.enumeration.HousingType;

/**
 * A DTO for the {@link com.example.demo.domain.Household} entity.
 */
public class HouseholdDTO implements Serializable {
    
    private Long id;

    private HousingType housingType;

    private List<PersonDTO> familyMembers = new ArrayList<PersonDTO>();
    
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

    public List<PersonDTO> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(List<PersonDTO> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public Long getTotalHouseholdIncome() {
        return this.familyMembers.stream().
            reduce(0L, (subtotal, personDTO) -> Long.sum(subtotal, personDTO.getAnnualIncome()), Long::sum);
    }

    public Boolean hasMarriedCouple() {
        for (PersonDTO person: familyMembers) {
            if (person.getSpouse() != null
                && this.familyMembers
                    .stream()
                    .anyMatch(personDTO -> (personDTO.getId() == person.getSpouse()
                        && personDTO.getSpouse() == person.getId()))) {
                return true;
            }
        }

        return false;
    }

    public Boolean hasMemberWithAgeRange(int min, int max) {
        return this.familyMembers
            .stream()
            .anyMatch(person -> {
                int age = Period.between(person.getDateOfBirth(), LocalDate.now()).getYears();
                return age >= min && age <= max;
                });
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
