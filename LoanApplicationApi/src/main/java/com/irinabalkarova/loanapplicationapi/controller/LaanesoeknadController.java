package com.irinabalkarova.loanapplicationapi.controller;

import com.irinabalkarova.loanapplicationapi.dto.ResponseResult;
import com.irinabalkarova.loanapplicationapi.model.Laanesoeknad;
import com.irinabalkarova.loanapplicationapi.model.Status;
import com.irinabalkarova.loanapplicationapi.service.LaanesoeknadService;
import io.swagger.annotations.ApiOperation;
import lombok.Builder;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequestMapping("/v1/application")
@CrossOrigin(origins = "http://localhost:4200")
@EnableSwagger2
@Builder
public class LaanesoeknadController {

    private LaanesoeknadService loanApplicationService;

    @Autowired
    public void setLoanApplicationService(LaanesoeknadService loanApplicationService) {
        this.loanApplicationService = loanApplicationService;
    }

    @PostMapping
    @ApiOperation(value = "Create a new loan application", response = ResponseEntity.class)
    public ResponseEntity<ResponseResult<Laanesoeknad>> post(@RequestBody @Valid Laanesoeknad laanesoeknad){
        log.info("Request from 4200 to create a new loan application: \n" + laanesoeknad.toString());
        try {
            this.loanApplicationService.add(laanesoeknad);
            return new ResponseEntity<>(new ResponseResult<>(null, laanesoeknad), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new ResponseResult<>(e.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Get a loan application's status by ID", response = ResponseEntity.class)
    public ResponseEntity<ResponseResult<Status>> get(@PathVariable UUID id){
        try {
            Status status = this.loanApplicationService.getStatusById(id);
            return new ResponseEntity<>(new ResponseResult<>(null, status), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(new ResponseResult<>(null, Status.ukjent), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    @ApiOperation(value = "Get all the applications", response = ResponseEntity.class)
    public ResponseEntity<ResponseResult<List<Laanesoeknad>>> getAllSoeknader(){
        try {
            List<Laanesoeknad> soeknader = this.loanApplicationService.getAllLaanesoeknader();
            return new ResponseEntity<>(new ResponseResult<>(null, soeknader), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(new ResponseResult<>("Applications could not be returned", null), HttpStatus.BAD_REQUEST);
        }
    }
}

