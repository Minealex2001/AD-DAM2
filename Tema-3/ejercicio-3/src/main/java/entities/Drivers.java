package entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.net.URI;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
public class Drivers {
    ObjectId id;
    int driverid;
    String code;
    String forename;
    String surname;
    Date dob;
    String nationality;
    Constructor constructors;
    String url;

    public Drivers( int driverid, String code, String forename, String surname, Date dob, String nationality, Constructor constructors, String url) {
        this.driverid = driverid;
        this.code = code;
        this.forename = forename;
        this.surname = surname;
        this.dob = dob;
        this.nationality = nationality;
        this.constructors = constructors;
        this.url = url;
    }
}
