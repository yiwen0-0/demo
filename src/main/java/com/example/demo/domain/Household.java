package com.example.demo.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

import com.example.demo.domain.enumeration.HousingType;

/**
 * A Household.
 */
@Entity
@Table(name = "tbl_household")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Household implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "housing_type")
    private HousingType housingType;

    @OneToMany(mappedBy = "household")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Person> people = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HousingType getHousingType() {
        return housingType;
    }

    public Household housingType(HousingType housingType) {
        this.housingType = housingType;
        return this;
    }

    public void setHousingType(HousingType housingType) {
        this.housingType = housingType;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public Household people(Set<Person> people) {
        this.people = people;
        return this;
    }

    public Household addPerson(Person person) {
        this.people.add(person);
        person.setHousehold(this);
        return this;
    }

    public Household removePerson(Person person) {
        this.people.remove(person);
        person.setHousehold(null);
        return this;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Household)) {
            return false;
        }
        return id != null && id.equals(((Household) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Household{" +
            "id=" + getId() +
            ", housingType='" + getHousingType() + "'" +
            "}";
    }
}
