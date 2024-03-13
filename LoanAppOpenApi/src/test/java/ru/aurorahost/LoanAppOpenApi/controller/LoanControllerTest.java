package ru.aurorahost.LoanAppOpenApi.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.aurorahost.LoanAppOpenApi.controllers.LoanController;
import ru.aurorahost.LoanAppOpenApi.entity.LaanesoeknadEntity;
import ru.aurorahost.LoanAppOpenApi.services.LoanService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import ru.aurorahost.LoanAppOpenApi.model.Laanesoeknad;

public class LoanControllerTest {

    @Mock
    private LoanService loanService;

    private LoanController loanController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        loanController = new LoanController(loanService);
    }

    @Test
    void testCreateLoanApplication_Success() throws Exception {
        Laanesoeknad laanesoeknad = new Laanesoeknad();
        when(loanService.createLaanesoeknad(laanesoeknad)).thenReturn(Optional.of(new LaanesoeknadEntity()));

        ResponseEntity<Void> response = loanController.createLoanApplication(laanesoeknad);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(loanService, times(1)).createLaanesoeknad(laanesoeknad);
    }

    @Test
    void testCreateLoanApplication_BadRequest() throws Exception {
        Laanesoeknad laanesoeknad = new Laanesoeknad();
        when(loanService.createLaanesoeknad(laanesoeknad)).thenReturn(Optional.empty());

        ResponseEntity<Void> response = loanController.createLoanApplication(laanesoeknad);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        verify(loanService, times(1)).createLaanesoeknad(laanesoeknad);
    }

    @Test
    void testGetAllLoanApplications() throws Exception {
        List<Laanesoeknad> entities = Collections.singletonList(new Laanesoeknad());
        when(loanService.getAllLaanesoeknads()).thenReturn(entities);

        ResponseEntity<List<Laanesoeknad>> response = loanController.getAllLoanApplications();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(entities.size(), response.getBody().size());
        verify(loanService, times(1)).getAllLaanesoeknads();
    }

    @Test
    void testGetLoanApplicationStatus_Success() throws Exception {
        Integer id = 1;
        Optional<String> expectedStatus = Optional.of("mottatt"); // Extracted status value

        // Stubbing the service method
        when(loanService.getLaanesoeknadStatus(Long.valueOf(id))).thenReturn(expectedStatus);

        // Call the controller method
        ResponseEntity<String> response = loanController.getLoanApplicationStatus(id);

        // Assert the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedStatus.toString(), response.getBody()); // Compare with extracted status value
        verify(loanService, times(1)).getLaanesoeknadStatus(Long.valueOf(id));
    }

    @Test
    void testGetLoanApplicationStatus_NotFound() throws Exception {
        Integer id = 1;
        when(loanService.getLaanesoeknadStatus(Long.valueOf(id))).thenReturn(Optional.empty());

        ResponseEntity<String> response = loanController.getLoanApplicationStatus(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(loanService, times(1)).getLaanesoeknadStatus(Long.valueOf(id));
    }

}
