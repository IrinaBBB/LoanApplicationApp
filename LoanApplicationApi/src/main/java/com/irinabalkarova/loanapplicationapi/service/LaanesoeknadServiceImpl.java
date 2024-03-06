package com.irinabalkarova.loanapplicationapi.service;

import com.irinabalkarova.loanapplicationapi.exception.ConstraintViolationException;
import com.irinabalkarova.loanapplicationapi.model.Laanesoeknad;
import com.irinabalkarova.loanapplicationapi.model.Status;
import com.irinabalkarova.loanapplicationapi.repository.LaanesoeknadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class LaanesoeknadServiceImpl implements LaanesoeknadService {

    private LaanesoeknadRepository repository;

    @Autowired
    public void setRepository(LaanesoeknadRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(Laanesoeknad loanApplication) {
        try {
            this.repository.save(loanApplication);
        } catch (ConstraintViolationException e) {
            log.error(e.getMessage());
            throw new IllegalArgumentException("This loan application has already been created");
        }
    }

    @Override
    public Status getStatusById(UUID id) {
        Laanesoeknad loanApplication
                = this.repository.getLaanesoeknadById(id).orElseThrow(
                () -> new IllegalArgumentException("Id not found"));
        return loanApplication.getStatus();
    }

    @Override
    public List<Laanesoeknad> getAllLaanesoeknader() {
        return repository.getAll();
    }
}
