package com.example.demo.repository;

import com.example.demo.domain.Household;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Household entity.
 */
@SuppressWarnings("unused")
@Repository
public interface HouseholdRepository extends JpaRepository<Household, Long>, JpaSpecificationExecutor<Household> {
}
