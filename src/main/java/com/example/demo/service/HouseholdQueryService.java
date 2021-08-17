package com.example.demo.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import com.example.demo.domain.Household;
import com.example.demo.domain.*; // for static metamodels
import com.example.demo.repository.HouseholdRepository;
import com.example.demo.service.dto.HouseholdCriteria;
import com.example.demo.service.dto.HouseholdDTO;
import com.example.demo.service.mapper.HouseholdMapper;

/**
 * Service for executing complex queries for {@link Household} entities in the database.
 * The main input is a {@link HouseholdCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link HouseholdDTO} or a {@link Page} of {@link HouseholdDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class HouseholdQueryService extends QueryService<Household> {

    private final Logger log = LoggerFactory.getLogger(HouseholdQueryService.class);

    private final HouseholdRepository householdRepository;

    private final HouseholdMapper householdMapper;

    public HouseholdQueryService(HouseholdRepository householdRepository, HouseholdMapper householdMapper) {
        this.householdRepository = householdRepository;
        this.householdMapper = householdMapper;
    }

    /**
     * Return a {@link List} of {@link HouseholdDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<HouseholdDTO> findByCriteria(HouseholdCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Household> specification = createSpecification(criteria);
        return householdMapper.toDto(householdRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link HouseholdDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<HouseholdDTO> findByCriteria(HouseholdCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Household> specification = createSpecification(criteria);
        return householdRepository.findAll(specification, page)
            .map(householdMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(HouseholdCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Household> specification = createSpecification(criteria);
        return householdRepository.count(specification);
    }

    /**
     * Function to convert {@link HouseholdCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Household> createSpecification(HouseholdCriteria criteria) {
        Specification<Household> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Household_.id));
            }
            if (criteria.getHousingType() != null) {
                specification = specification.and(buildSpecification(criteria.getHousingType(), Household_.housingType));
            }
            if (criteria.getPersonId() != null) {
                specification = specification.and(buildSpecification(criteria.getPersonId(),
                    root -> root.join(Household_.people, JoinType.LEFT).get(Person_.id)));
            }
        }
        return specification;
    }
}
