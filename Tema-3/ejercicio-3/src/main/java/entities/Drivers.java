package entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.Calendar;
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

    public Drivers(int driverid, String code, String forename, String surname, Date dob, String nationality, Constructor constructors, String url) {
        this.driverid = driverid;
        this.code = code;
        this.forename = forename;
        this.surname = surname;
        this.dob = dob;
        this.nationality = nationality;
        this.constructors = constructors;
        this.url = url;
    }

    public int getAgeIn2006() {
        // Asume que dob es un java.util.Date
        Calendar dobCalendar = Calendar.getInstance();
        dobCalendar.setTime(this.dob);
        int birthYear = dobCalendar.get(Calendar.YEAR);
        return 2006 - birthYear;
    }
}
