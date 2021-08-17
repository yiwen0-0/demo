package com.example.demo.service;

import com.example.demo.domain.Household;
import com.example.demo.repository.HouseholdRepository;
import com.example.demo.service.dto.HouseholdDTO;
import com.example.demo.service.mapper.HouseholdMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Household}.
 */
@Service
@Transactional
public class HouseholdService {

    private final Logger log = LoggerFactory.getLogger(HouseholdService.class);

    private final HouseholdRepository householdRepository;

    private final HouseholdMapper householdMapper;

    public HouseholdService(HouseholdRepository householdRepository, HouseholdMapper householdMapper) {
        this.householdRepository = householdRepository;
        this.householdMapper = householdMapper;
    }

    /**
     * Save a household.
     *
     * @param householdDTO the entity to save.
     * @return the persisted entity.
     */
    public HouseholdDTO save(HouseholdDTO householdDTO) {
        log.debug("Request to save Household : {}", householdDTO);
        Household household = householdMapper.toEntity(householdDTO);
        household = householdRepository.save(household);
        return householdMapper.toDto(household);
    }

    /**
     * Get all the households.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<HouseholdDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Households");
        return householdRepository.findAll(pageable)
            .map(householdMapper::toDto);
    }

    /**
     * Get one household by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<HouseholdDTO> findOne(Long id) {
        log.debug("Request to get Household : {}", id);
        return householdRepository.findById(id)
            .map(householdMapper::toDto);
    }

    /**
     * Delete the household by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Household : {}", id);
        householdRepository.deleteById(id);
    }
}
