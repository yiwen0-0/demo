package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;

import com.example.demo.domain.enumeration.Gender;
import com.example.demo.domain.enumeration.MaritalStatus;
import com.example.demo.domain.enumeration.OccupationType;

/**
 * A Person.
 */
@Entity
@Table(name = "tbl_person")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "marital_status", nullable = false)
    private MaritalStatus maritalStatus;

    @Column(name = "spouse")
    private Long spouse;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "occupation_type", nullable = false)
    private OccupationType occupationType;

    @Column(name = "annual_income")
    private Long annualIncome;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @ManyToOne
    @JsonIgnoreProperties("people")
    private Household household;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Person name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public Person gender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Long getSpouse() {
        return spouse;
    }

    public Person spouse(Long spouse) {
        this.spouse = spouse;
        return this;
    }

    public void setSpouse(Long spouse) {
        this.spouse = spouse;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public Person maritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
        return this;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public OccupationType getOccupationType() {
        return occupationType;
    }

    public Person occupationType(OccupationType occupationType) {
        this.occupationType = occupationType;
        return this;
    }

    public void setOccupationType(OccupationType occupationType) {
        this.occupationType = occupationType;
    }

    public Long getAnnualIncome() {
        return annualIncome;
    }

    public Person annualIncome(Long annualIncome) {
        this.annualIncome = annualIncome;
        return this;
    }

    public void setAnnualIncome(Long annualIncome) {
        this.annualIncome = annualIncome;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Person dateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Household getHousehold() {
        return household;
    }

    public Person household(Household household) {
        this.household = household;
        return this;
    }

    public void setHousehold(Household household) {
        this.household = household;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        return id != null && id.equals(((Person) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Person{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", gender='" + getGender() + "'" +
            ", maritalStatus='" + getMaritalStatus() + "'" +
            ", spouse='" + getSpouse() + "'" +
            ", occupationType='" + getOccupationType() + "'" +
            ", annualIncome=" + getAnnualIncome() +
            ", dateOfBirth='" + getDateOfBirth() + "'" +
            "}";
    }
}
