package ru.aurorahost.LoanAppOpenApi.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.aurorahost.LoanAppOpenApi.LoanApi;
import ru.aurorahost.LoanAppOpenApi.entity.LaanesoeknadEntity;
import ru.aurorahost.LoanAppOpenApi.model.Laanesoeknad;
import ru.aurorahost.LoanAppOpenApi.services.LoanService;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class LoanController implements LoanApi {

    private static final Logger log = LoggerFactory.getLogger(LoanController.class);
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @Override
    public ResponseEntity<Void> createLoanApplication(Laanesoeknad laanesoeknad) throws Exception {
        Optional<LaanesoeknadEntity> optionalEntity = loanService.createLaanesoeknad(laanesoeknad);
        if (optionalEntity.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<List<Laanesoeknad>> getAllLoanApplications() throws Exception {
        return ok(loanService.getAllLaanesoeknads());
    }

    @Override
    public ResponseEntity<String> getLoanApplicationStatus(Integer id) throws Exception {
        Optional<String> optionalEntity = loanService.getLaanesoeknadStatus(Long.valueOf(id));
        if (optionalEntity.isPresent()) {
            return ok(optionalEntity.toString());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
