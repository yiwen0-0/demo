package com.example.demo.web.rest;

import com.example.demo.service.HouseholdService;
import com.example.demo.web.rest.errors.BadRequestAlertException;
import com.example.demo.service.dto.HouseholdDTO;
import com.example.demo.service.dto.HouseholdCriteria;
import com.example.demo.service.HouseholdQueryService;

import com.example.demo.web.rest.util.grantUtil.*;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.demo.service.constant.GrantConstants.*;

/**
 * REST controller for managing {@link com.example.demo.domain.Household}.
 */
@RestController
@RequestMapping("/api")
public class HouseholdResource {

    private final Logger log = LoggerFactory.getLogger(HouseholdResource.class);

    private static final String ENTITY_NAME = "household";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final HouseholdService householdService;

    private final HouseholdQueryService householdQueryService;

    public HouseholdResource(HouseholdService householdService, HouseholdQueryService householdQueryService) {
        this.householdService = householdService;
        this.householdQueryService = householdQueryService;
    }

    /**
     * {@code POST  /households} : Create a new household.
     *
     * @param householdDTO the householdDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new householdDTO, or with status {@code 400 (Bad Request)} if the household has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/households")
    public ResponseEntity<HouseholdDTO> createHousehold(@RequestBody HouseholdDTO householdDTO) throws URISyntaxException {
        log.debug("REST request to save Household : {}", householdDTO);
        if (householdDTO.getId() != null) {
            throw new BadRequestAlertException("A new household cannot already have an ID", ENTITY_NAME, "idexists");
        }
        HouseholdDTO result = householdService.save(householdDTO);
        return ResponseEntity.created(new URI("/api/households/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /households} : Updates an existing household.
     *
     * @param householdDTO the householdDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated householdDTO,
     * or with status {@code 400 (Bad Request)} if the householdDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the householdDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/households")
    public ResponseEntity<HouseholdDTO> updateHousehold(@RequestBody HouseholdDTO householdDTO) throws URISyntaxException {
        log.debug("REST request to update Household : {}", householdDTO);
        if (householdDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        HouseholdDTO result = householdService.save(householdDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, householdDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /households} : get all the households.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of households in body.
     */
    @GetMapping("/households")
    public ResponseEntity<List<HouseholdDTO>> getAllHouseholds(HouseholdCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Households by criteria: {}", criteria);
        Page<HouseholdDTO> page = householdQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /households/count} : count all the households.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/households/count")
    public ResponseEntity<Long> countHouseholds(HouseholdCriteria criteria) {
        log.debug("REST request to count Households by criteria: {}", criteria);
        return ResponseEntity.ok().body(householdQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /households/:id} : get the "id" household.
     *
     * @param id the id of the householdDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the householdDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/households/{id}")
    public ResponseEntity<HouseholdDTO> getHousehold(@PathVariable Long id) {
        log.debug("REST request to get Household : {}", id);
        Optional<HouseholdDTO> householdDTO = householdService.findOne(id);
        return ResponseUtil.wrapOrNotFound(householdDTO);
    }

    /**
     * {@code DELETE  /households/:id} : delete the "id" household.
     *
     * @param id the id of the householdDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/households/{id}")
    public ResponseEntity<Void> deleteHousehold(@PathVariable Long id) {
        log.debug("REST request to delete Household : {}", id);
        householdService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }

    /**
     * {@code GET  /households/grant} : get all the households of grant disbursement and given criteria.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
     */
    @GetMapping("/households/grant")
    public ResponseEntity<List<HouseholdDTO>> countHouseholds(HouseholdCriteria criteria,
        @RequestParam String type, @RequestParam(required = false) Integer householdSize,
        @RequestParam(required = false) Long totalIncome) {
        log.debug("REST request to count Households by criteria: {}", criteria);
        String grantType = GRANT_SCHEMES.get(type);
        List<HouseholdDTO> households = householdQueryService.findByCriteria(criteria);

        if (householdSize != null) {
            households = households.stream()
                .filter(household -> household.getFamilyMembers().size() <= householdSize)
                .collect(Collectors.toList());
        }

        if (totalIncome != null) {
            households = households.stream()
                .filter(household -> household.getTotalHouseholdIncome() <= totalIncome)
                .collect(Collectors.toList());
        }

        GrantSearchEngine grantSearchEngine = null;

        switch(grantType) {
            case "Student Encouragement Bonus":
                grantSearchEngine = new StudentEncouragementBonus();
                break;
            case "Family Togetherness Scheme":
                grantSearchEngine = new FamilyTogethernessScheme();
                break;
            case "Elder Bonus":
                grantSearchEngine = new ElderBonus();
                break;
            case "Baby Sunshine Grant":
                grantSearchEngine = new BabySunshineGrant();
                break;
            case "YOLO GST Grant":
                grantSearchEngine = new YOLOGSTGrant();
                break;
            default:
                break;
        }
        
        if (grantSearchEngine == null) {
            throw new BadRequestAlertException("Invalid Grant Type", ENTITY_NAME, "invalidGrantType");
        }
        households = grantSearchEngine.getValidHouseholds(households);

        return ResponseEntity.ok().body(households);
    }
}
