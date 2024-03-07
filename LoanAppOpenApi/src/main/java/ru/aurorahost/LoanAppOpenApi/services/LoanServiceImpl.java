package ru.aurorahost.LoanAppOpenApi.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.aurorahost.LoanAppOpenApi.entity.LaanesoeknadEntity;
import ru.aurorahost.LoanAppOpenApi.entity.LaanetakerEntity;
import ru.aurorahost.LoanAppOpenApi.model.Laanesoeknad;
import ru.aurorahost.LoanAppOpenApi.model.Laanetaker;
import ru.aurorahost.LoanAppOpenApi.repository.LaanesoeknadRepository;
import ru.aurorahost.LoanAppOpenApi.repository.LaanetakerRepository;

import java.util.*;

@Service
public class LoanServiceImpl implements LoanService {
    private final LaanesoeknadRepository laanesoeknadRepository;
    private final LaanetakerRepository laanetakerRepository;
    private final ModelMapper modelMapper;

    public LoanServiceImpl(LaanesoeknadRepository laanesoeknadRepository, LaanetakerRepository laanetakerRepository, ModelMapper modelMapper) {
        this.laanesoeknadRepository = laanesoeknadRepository;
        this.laanetakerRepository = laanetakerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<LaanesoeknadEntity> createLaanesoeknad(Laanesoeknad laanesoeknad) {

        LaanesoeknadEntity laanesoeknadEntity = modelMapper.map(laanesoeknad, LaanesoeknadEntity.class);

        Set<LaanetakerEntity> savedLaanetakere = new HashSet<>();
        for (Laanetaker laanetaker : laanesoeknad.getLanetakere()) {
            Optional<LaanetakerEntity> existingLaanetaker = Optional.ofNullable(laanetakerRepository
                    .findByFoedselsnummer(laanetaker.getFoedselsnummer()));
            if (existingLaanetaker.isPresent()) {
                savedLaanetakere.add(existingLaanetaker.get());
            } else {
                LaanetakerEntity newLaanetakerEntity = modelMapper.map(laanetaker, LaanetakerEntity.class);
                savedLaanetakere.add(laanetakerRepository.save(newLaanetakerEntity));
            }
        }

        laanesoeknadEntity.setLanetakere(savedLaanetakere);
        LaanesoeknadEntity savedEntity = laanesoeknadRepository.save(laanesoeknadEntity);

        return Optional.of(savedEntity);
    }

    @Override
    public Optional<String> getLaanesoeknadStatus(Long id) {
        Optional<LaanesoeknadEntity> laanesoeknadOptional = laanesoeknadRepository.findById(id);

        if (laanesoeknadOptional.isPresent()) {
            LaanesoeknadEntity laanesoeknadEntity = laanesoeknadOptional.get();
            return Optional.ofNullable(laanesoeknadEntity.getStatus());
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Laanesoeknad> getAllLaanesoeknads() {
        Iterable<LaanesoeknadEntity> iterable = laanesoeknadRepository.findAll();
        List<Laanesoeknad> list = new ArrayList<>();
        iterable.forEach(entity -> list.add(modelMapper.map(entity, Laanesoeknad.class)));
        return list;
    }
}
