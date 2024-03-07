package ru.aurorahost.LoanAppOpenApi.controllers;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.aurorahost.LoanAppOpenApi.LoanApi;
import ru.aurorahost.LoanAppOpenApi.ShopOpenApi.model.Laanesoeknad;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class LoanController implements LoanApi {

    private static final Logger log = LoggerFactory.getLogger(LoanController.class);

    @Override
    public ResponseEntity<Void> createLoanApplication(@Valid Laanesoeknad laanesoeknad) throws Exception {
        return LoanApi.super.createLoanApplication(laanesoeknad);
    }

    @Override
    public ResponseEntity<List<Laanesoeknad>> getAllLoanApplications() throws Exception {
        log.info("Request for customer ID:!!!!!!!!!!!!!!!!!!!!!!");
        return ok(Collections.EMPTY_LIST);
    }

    @Override
    public ResponseEntity<Laanesoeknad> getLoanApplicationStatus(UUID id) throws Exception {
        return ok(new Laanesoeknad());
    }
}
