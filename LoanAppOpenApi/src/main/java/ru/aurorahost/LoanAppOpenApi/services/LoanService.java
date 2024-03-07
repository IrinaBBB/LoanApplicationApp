package ru.aurorahost.LoanAppOpenApi.services;

import ru.aurorahost.LoanAppOpenApi.entity.LaanesoeknadEntity;
import ru.aurorahost.LoanAppOpenApi.model.Laanesoeknad;

import java.util.List;
import java.util.Optional;

public interface LoanService {

    Optional<LaanesoeknadEntity> createLaanesoeknad(Laanesoeknad laanesoeknad);
    Optional<String> getLaanesoeknadStatus(Long id);
    List<Laanesoeknad> getAllLaanesoeknads();
}
