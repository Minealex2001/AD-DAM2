package src.objetos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Drivers {
    String driverId;
    int permanentNumber;
    String code;
    String url;
    String givenName;
    String familyName;
    LocalDate dateOfBirth;
    String nationality;

    @Override
    public String toString() {
        return "Drivers " +
                "Driver: " + givenName + " " + familyName+
                ", permanentNumber= " + permanentNumber +
                ", code= " + code +
                ", url= " + url +
                ", dateOfBirth= " + dateOfBirth +
                ", nationality= " + nationality ;
    }
}
