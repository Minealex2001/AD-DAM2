package org.alejandro.ejercicio3.mapper;

import org.alejandro.ejercicio3.dto.DriverDTO;
import org.alejandro.ejercicio3.entity.Driver;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class DriverDTOMapper implements Function<Driver, DriverDTO> {

        @Override
        public DriverDTO apply(Driver driver) {
            return new DriverDTO(
                    driver.getId(),
                    driver.getCode(),
                    driver.getForename() + " " + driver.getSurname(),
                    driver.getNationality(),
                    driver.getConstructor().getName()
            );
        }
}
