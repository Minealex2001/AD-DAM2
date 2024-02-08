package org.alejandro.ejercicio3.service.Driver;

import org.alejandro.ejercicio3.dto.DriverDTO;
import org.alejandro.ejercicio3.dto.DriverDetail;
import org.alejandro.ejercicio3.entity.Driver;
import org.alejandro.ejercicio3.mapper.DriverDTOMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.alejandro.ejercicio3.repository.DriverRepository;

import java.util.List;
import java.util.Optional;

// Implementación del servicio para la entidad Driver
@Service
public class DriverServiceImpl implements DriverService{
    // Repositorio para gestionar los drivers en la base de datos
    private final DriverRepository driverRepository;
    public final DriverDTOMapper DriverDTOMapper = new DriverDTOMapper();


    // Inyección de dependencias del repositorio
    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    // Método para obtener todos los drivers
    @Override
    public List<DriverDTO> getAllDrivers() {
        return driverRepository.findAll().stream().map(DriverDTOMapper).toList();
    }

    // Método para obtener un driver por su código
    @Override
    public Optional<Driver> getDriverByCode(String code) {
        return driverRepository.findByCodeIgnoreCase(code);
    }

    // Método para guardar un driver (tanto para crear como para actualizar)
    @Override
    public void saveDriver(Driver driver) {
        driverRepository.save(driver);
    }

    // Método para eliminar un driver por su código
    @Override
    public void deleteDriver(String code) {
        driverRepository.deleteByCode(code);
    }

    @Override
    public Page<DriverDetail> getAllDriversResponse(int pageKey, int pageSize, String sortBy, String sortDirect) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirect), sortBy);
        Pageable pageable = PageRequest.of(pageKey, pageSize, sort);
        return driverRepository.findAllProjectedBy(pageable);
    }
}