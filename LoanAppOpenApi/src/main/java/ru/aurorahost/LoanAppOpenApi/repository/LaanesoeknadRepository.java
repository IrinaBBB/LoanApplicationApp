package ru.aurorahost.LoanAppOpenApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.aurorahost.LoanAppOpenApi.entity.LaanesoeknadEntity;
import ru.aurorahost.LoanAppOpenApi.entity.LaanetakerEntity;

@Repository
public interface LaanesoeknadRepository extends CrudRepository<LaanesoeknadEntity, Long> {
}
