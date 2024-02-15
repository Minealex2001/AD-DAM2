package org.api.springf1.service;

import org.api.springf1.dto.DriverDTO;
import org.api.springf1.model.Driver;
import org.api.springf1.repository.DriverRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.postgresql.hostchooser.HostRequirement.any;

@ExtendWith(MockitoExtension.class)
class DriverServiceImplTest {

    @Mock
    private DriverRepository driverRepository;

    @InjectMocks
    private DriverServiceImpl driverService;

    Driver driver;
    DriverDTO driverDTO;

    @BeforeEach
    void setup(){
        driver = Driver.builder()
                .id(1L)
                .code("HAM")
                .forename("Lewis")
                .surname("Hamilton")
                .build();

        driverDTO = DriverDTO.builder()
                .id(1L)
                .code("HAM")
                .forename("Lewis")
                .surname("Hamilton")
                .build();
    }

    @Test
    void shouldReturnDriverDTOWhenCreateDriver(){
        when(driverRepository.save(any(Driver.class))).thenReturn(driver);

        DriverDTO saveDriver = driverService.saveDriver(driver);

        assertNotNull(saveDriver);
        assertEquals("HAM", saveDriver.code());

        verify(driverRepository, times(1)).save(any(Driver.class));
    }

    @Test
    void shouldReturnDriverDTOWhenFindDriverByCode(){
        when(driverRepository.findByCodeIgnoreCase("HAM")).thenReturn(java.util.Optional.of(driver));

        DriverDTO driverByCode = driverService.getDriverByCode("HAM");

        assertNotNull(driverByCode);
        assertEquals("HAM", driverByCode.code());
    }

    @Test
    void shouldReturnDriverDTOWhenUpdateDriver(){
        when(driverRepository.findById(1L)).thenReturn(java.util.Optional.of(driver));
        when(driverRepository.save(any(Driver.class))).thenReturn(driver);

        DriverDTO updateDriver = driverService.updateDriver(driver);

        assertNotNull(updateDriver);
        assertEquals("HAM", updateDriver.code());

        verify(driverRepository, times(1)).findById(1L);
        verify(driverRepository, times(1)).save(any(Driver.class));
    }

    @Test
    void shouldReturnNothingWhenDeleteDriverByCode(){
        when(driverRepository.findByCodeIgnoreCase("HAM")).thenReturn(java.util.Optional.of(driver));

        driverService.deleteDriverByCode("HAM");

        assert(1L == driver.getId());
        verify(driverRepository, times(1)).delete(any(Driver.class));
    }

    @Test
    void shouldReturnDriverResponseWhenGetAllDrivers(){
        when(driverRepository.findAll(any(Pageable.class))).thenReturn(null);

        driverService.getDrivers(0, 10);

        verify(driverRepository, times(1)).findAll(any(Pageable.class));
    }
}