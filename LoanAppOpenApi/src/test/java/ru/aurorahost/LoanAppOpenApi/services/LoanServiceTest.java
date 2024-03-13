package ru.aurorahost.LoanAppOpenApi.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import ru.aurorahost.LoanAppOpenApi.controllers.LoanController;
import ru.aurorahost.LoanAppOpenApi.entity.LaanesoeknadEntity;
import ru.aurorahost.LoanAppOpenApi.entity.LaanetakerEntity;
import ru.aurorahost.LoanAppOpenApi.model.Laanesoeknad;
import ru.aurorahost.LoanAppOpenApi.model.Laanetaker;
import ru.aurorahost.LoanAppOpenApi.repository.LaanesoeknadRepository;
import ru.aurorahost.LoanAppOpenApi.repository.LaanetakerRepository;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LoanServiceTest {
    @InjectMocks
    private LoanServiceImpl loanService;
    @Mock
    private LaanesoeknadRepository laanesoeknadRepository;
    @Mock
    private LaanetakerRepository laanetakerRepository = mock(LaanetakerRepository.class);
    @Mock
    private ModelMapper modelMapper = mock(ModelMapper.class);

    private static Laanesoeknad laanesoeknad;

    @BeforeAll
    public static void setup() {
        laanesoeknad = new Laanesoeknad();
    }

    @Test
    public void testCreateLaanesoeknad_Success() {
        
    }

}
