package com.irinabalkarova.loanapplicationapi.controller;

import com.irinabalkarova.loanapplicationapi.model.Laanetype;
import com.irinabalkarova.loanapplicationapi.model.Status;
import com.irinabalkarova.loanapplicationapi.service.LaanesoeknadService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@Log4j2
@RequestMapping("/v1/loan")
@CrossOrigin(origins = "http://localhost:4200")
@EnableSwagger2
public class LaanController {

    @GetMapping("/statuses")
    public Status[] getAllStatuses() {
        return Status.values();
    }

    @GetMapping("/laan-typer")
    public Laanetype[] getAllLoanTypes() {
        return Laanetype.values();
    }
}

