package com.irinabalkarova.loanapplicationapi.repository;

import com.irinabalkarova.loanapplicationapi.exception.ConstraintViolationException;
import com.irinabalkarova.loanapplicationapi.model.Laanesoeknad;
import com.irinabalkarova.loanapplicationapi.model.Laanetaker;
import com.irinabalkarova.loanapplicationapi.model.Laanetype;
import com.irinabalkarova.loanapplicationapi.model.Status;
import com.irinabalkarova.loanapplicationapi.service.LaanesoeknadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
@Slf4j
public class LaanesoeknadRepository {

    private final Map<UUID, Laanesoeknad> laanesoeknader;

    public LaanesoeknadRepository() {
        this.laanesoeknader = new HashMap<>();

        List<Laanetaker> laanetakere1 = new ArrayList<>();
        laanetakere1.add(Laanetaker.builder()
                .id(UUID.randomUUID())
                .foedselsnummer(12059612345L)
                .navn("Hans Hansen")
                .foedselsdato(LocalDate.of(1996, 5, 12))
                .build());
        laanetakere1.add(Laanetaker.builder()
                .id(UUID.randomUUID())
                .foedselsnummer(15029354321L)
                .navn("Line Jensen")
                .foedselsdato(LocalDate.of(1993, 2, 15))
                .build());

        Laanesoeknad laanesoeknad1 = Laanesoeknad
                .builder()
                .id(UUID.randomUUID())
                .lanetakere(laanetakere1)
                .lanebelop(100000.0)
                .behov("Økonomisk støtte")
                .lopetid(36)
                .avdragsfriPeriode(6)
                .type(Laanetype.annuitet)
                .status(Status.behandles)
                .build();

        List<Laanetaker> laanetakere2 = new ArrayList<>();
        laanetakere2.add(Laanetaker.builder()
                .id(UUID.randomUUID())
                .foedselsnummer(12059612345L)
                .navn("Hans Hansen")
                .foedselsdato(LocalDate.of(1996, 5, 12))
                .build());
        laanetakere2.add(Laanetaker.builder()
                .id(UUID.randomUUID())
                .foedselsnummer(15029354321L)
                .navn("Line Jensen")
                .foedselsdato(LocalDate.of(1993, 2, 15))
                .build());

        Laanesoeknad laanesoeknad2 = Laanesoeknad
                .builder()
                .id(UUID.randomUUID())
                .lanetakere(laanetakere2)
                .lanebelop(100000.0)
                .behov("Økonomisk støtte")
                .lopetid(36)
                .avdragsfriPeriode(6)
                .type(Laanetype.annuitet)
                .status(Status.motatt)
                .build();
        laanesoeknader.put(laanesoeknad1.getId(), laanesoeknad1);
        laanesoeknader.put(laanesoeknad2.getId(), laanesoeknad2);
    }

    public void save(Laanesoeknad laanesoeknad) throws ConstraintViolationException {
        laanesoeknad.setId(UUID.randomUUID());
        laanesoeknad.setStatus(Status.motatt);
//        if(this.laanesoeknader.containsValue(laanesoeknad)){
//            log.error("Database Error: could not create new loan application");
//            throw new ConstraintViolationException();
//        }
        this.laanesoeknader.put(laanesoeknad.getId(), laanesoeknad);
        log.info("Loan Application has been saved with ID " + (laanesoeknad.getId()));
    }

    public Optional<Laanesoeknad> getLaanesoeknadById(UUID id) {
        Laanesoeknad laanesoeknad = laanesoeknader.get(id);
        return Optional.ofNullable(laanesoeknad);
    }

    public List<Laanesoeknad> getAll() {
        return new ArrayList<>(laanesoeknader.values());
    }
}
