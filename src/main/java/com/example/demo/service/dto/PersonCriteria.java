package com.example.demo.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import com.example.demo.domain.enumeration.Gender;
import com.example.demo.domain.enumeration.MaritalStatus;
import com.example.demo.domain.enumeration.OccupationType;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.LocalDateFilter;

/**
 * Criteria class for the {@link com.example.demo.domain.Person} entity. This class is used
 * in {@link com.example.demo.web.rest.PersonResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /people?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class PersonCriteria implements Serializable, Criteria {
    /**
     * Class for filtering Gender
     */
    public static class GenderFilter extends Filter<Gender> {

        public GenderFilter() {
        }

        public GenderFilter(GenderFilter filter) {
            super(filter);
        }

        @Override
        public GenderFilter copy() {
            return new GenderFilter(this);
        }

    }
    /**
     * Class for filtering MaritalStatus
     */
    public static class MaritalStatusFilter extends Filter<MaritalStatus> {

        public MaritalStatusFilter() {
        }

        public MaritalStatusFilter(MaritalStatusFilter filter) {
            super(filter);
        }

        @Override
        public MaritalStatusFilter copy() {
            return new MaritalStatusFilter(this);
        }

    }
    /**
     * Class for filtering OccupationType
     */
    public static class OccupationTypeFilter extends Filter<OccupationType> {

        public OccupationTypeFilter() {
        }

        public OccupationTypeFilter(OccupationTypeFilter filter) {
            super(filter);
        }

        @Override
        public OccupationTypeFilter copy() {
            return new OccupationTypeFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter name;

    private GenderFilter gender;

    private MaritalStatusFilter maritalStatus;

    private OccupationTypeFilter occupationType;

    private LongFilter annualIncome;

    private LocalDateFilter dateOfBirth;

    private LongFilter householdId;

    public PersonCriteria() {
    }

    public PersonCriteria(PersonCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.name = other.name == null ? null : other.name.copy();
        this.gender = other.gender == null ? null : other.gender.copy();
        this.maritalStatus = other.maritalStatus == null ? null : other.maritalStatus.copy();
        this.occupationType = other.occupationType == null ? null : other.occupationType.copy();
        this.annualIncome = other.annualIncome == null ? null : other.annualIncome.copy();
        this.dateOfBirth = other.dateOfBirth == null ? null : other.dateOfBirth.copy();
        this.householdId = other.householdId == null ? null : other.householdId.copy();
    }

    @Override
    public PersonCriteria copy() {
        return new PersonCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getName() {
        return name;
    }

    public void setName(StringFilter name) {
        this.name = name;
    }

    public GenderFilter getGender() {
        return gender;
    }

    public void setGender(GenderFilter gender) {
        this.gender = gender;
    }

    public MaritalStatusFilter getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatusFilter maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public OccupationTypeFilter getOccupationType() {
        return occupationType;
    }

    public void setOccupationType(OccupationTypeFilter occupationType) {
        this.occupationType = occupationType;
    }

    public LongFilter getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(LongFilter annualIncome) {
        this.annualIncome = annualIncome;
    }

    public LocalDateFilter getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateFilter dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LongFilter getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(LongFilter householdId) {
        this.householdId = householdId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final PersonCriteria that = (PersonCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(name, that.name) &&
            Objects.equals(gender, that.gender) &&
            Objects.equals(maritalStatus, that.maritalStatus) &&
            Objects.equals(occupationType, that.occupationType) &&
            Objects.equals(annualIncome, that.annualIncome) &&
            Objects.equals(dateOfBirth, that.dateOfBirth) &&
            Objects.equals(householdId, that.householdId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        name,
        gender,
        maritalStatus,
        occupationType,
        annualIncome,
        dateOfBirth,
        householdId
        );
    }

    @Override
    public String toString() {
        return "PersonCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (name != null ? "name=" + name + ", " : "") +
                (gender != null ? "gender=" + gender + ", " : "") +
                (maritalStatus != null ? "maritalStatus=" + maritalStatus + ", " : "") +
                (occupationType != null ? "occupationType=" + occupationType + ", " : "") +
                (annualIncome != null ? "annualIncome=" + annualIncome + ", " : "") +
                (dateOfBirth != null ? "dateOfBirth=" + dateOfBirth + ", " : "") +
                (householdId != null ? "householdId=" + householdId + ", " : "") +
            "}";
    }

}
