package org.alejandro.ejercicio3.dto;

import org.springframework.beans.factory.annotation.Value;

public interface DriverDetail
{
    Long getDriverId();
    String getCode();
    @Value("#{target.forename + ' ' + target.surname}")
    String getFullname();

}