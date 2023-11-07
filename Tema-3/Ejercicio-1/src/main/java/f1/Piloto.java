package f1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Piloto {
    private int driverId;
    private String driverCode;
    private String driverForename;
    private String driverSurname;
    private LocalDate driverDOB;
    private String driverNationality;
    private int constructorId;
    private String url;

    public Piloto(int driverId, String driverCode, String driverForename, String driverSurname, LocalDate driverDOB, String driverNationality, int constructorId, String url) {
        this.driverId = driverId;
        this.driverCode = driverCode;
        this.driverForename = driverForename;
        this.driverSurname = driverSurname;
        this.driverDOB = LocalDate.parse(driverDOB.toString());
        this.driverNationality = driverNationality;
        this.constructorId = constructorId;
        this.url = url;
    }
}
