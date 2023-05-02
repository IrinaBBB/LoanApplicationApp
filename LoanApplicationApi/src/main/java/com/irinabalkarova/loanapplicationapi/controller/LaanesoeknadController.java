package com.irinabalkarova.loanapplicationapi.controller;

import com.irinabalkarova.loanapplicationapi.dto.ResponseResult;
import com.irinabalkarova.loanapplicationapi.model.Laanesoeknad;
import com.irinabalkarova.loanapplicationapi.service.LaanesoeknadService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequestMapping("/v1/application")
@CrossOrigin(origins = "http://localhost:4200")
public class LaanesoeknadController {

    private LaanesoeknadService loanApplicationService;

    @Autowired
    public void setLoanApplicationService(LaanesoeknadService loanApplicationService) {
        this.loanApplicationService = loanApplicationService;
    }

    @PostMapping
    public ResponseEntity<ResponseResult<Laanesoeknad>> post(@RequestBody Laanesoeknad laanesoeknad){
        log.info("Request from 4200");
        try {
            this.loanApplicationService.add(laanesoeknad);
            return new ResponseEntity<>(new ResponseResult<>(null, laanesoeknad), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new ResponseResult<>(e.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }
}
