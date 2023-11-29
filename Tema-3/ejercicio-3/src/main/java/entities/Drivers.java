package entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drivers {
    int driverId;
    String code;
    String forename;
    String surname;
    String nationality;
    LocalDate dob;
    Constructor constructor;
    URL url;
}
