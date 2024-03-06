package com.irinabalkarova.loanapplicationapi.service;

import com.irinabalkarova.loanapplicationapi.model.Laanesoeknad;
import com.irinabalkarova.loanapplicationapi.model.Status;

import java.util.List;
import java.util.UUID;

public interface LaanesoeknadService {
    void add(Laanesoeknad loanApplication);
    Status getStatusById(UUID id);
    List<Laanesoeknad> getAllLaanesoeknader();
}
