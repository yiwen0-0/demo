package com.example.demo.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import com.example.demo.domain.enumeration.HousingType;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the {@link com.example.demo.domain.Household} entity. This class is used
 * in {@link com.example.demo.web.rest.HouseholdResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /households?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class HouseholdCriteria implements Serializable, Criteria {
    /**
     * Class for filtering HousingType
     */
    public static class HousingTypeFilter extends Filter<HousingType> {

        public HousingTypeFilter() {
        }

        public HousingTypeFilter(HousingTypeFilter filter) {
            super(filter);
        }

        @Override
        public HousingTypeFilter copy() {
            return new HousingTypeFilter(this);
        }

    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private HousingTypeFilter housingType;

    private LongFilter personId;

    public HouseholdCriteria() {
    }

    public HouseholdCriteria(HouseholdCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.housingType = other.housingType == null ? null : other.housingType.copy();
        this.personId = other.personId == null ? null : other.personId.copy();
    }

    @Override
    public HouseholdCriteria copy() {
        return new HouseholdCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public HousingTypeFilter getHousingType() {
        return housingType;
    }

    public void setHousingType(HousingTypeFilter housingType) {
        this.housingType = housingType;
    }

    public LongFilter getPersonId() {
        return personId;
    }

    public void setPersonId(LongFilter personId) {
        this.personId = personId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final HouseholdCriteria that = (HouseholdCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(housingType, that.housingType) &&
            Objects.equals(personId, that.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        housingType,
        personId
        );
    }

    @Override
    public String toString() {
        return "HouseholdCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (housingType != null ? "housingType=" + housingType + ", " : "") +
                (personId != null ? "personId=" + personId + ", " : "") +
            "}";
    }

}
