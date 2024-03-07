package ru.aurorahost.LoanAppOpenApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.aurorahost.LoanAppOpenApi.entity.LaanesoeknadEntity;

@Repository
public interface LaanesoeknadRepository extends CrudRepository<LaanesoeknadEntity, Long> {
}
