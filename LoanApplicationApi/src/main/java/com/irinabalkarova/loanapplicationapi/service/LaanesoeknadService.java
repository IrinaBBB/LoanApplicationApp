package com.irinabalkarova.loanapplicationapi.service;

import com.irinabalkarova.loanapplicationapi.model.Laanesoeknad;
import com.irinabalkarova.loanapplicationapi.model.Status;

public interface LaanesoeknadService {
    void add(Laanesoeknad loanApplication);
    Status getStatusById(long id);
}
