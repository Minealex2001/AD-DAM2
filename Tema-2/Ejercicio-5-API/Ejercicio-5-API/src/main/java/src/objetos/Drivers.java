package src.objetos;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Drivers {
    String DriverName;
    String DriverNationality;
    String DriverBirthDate;
    int DriverNumber;
}
