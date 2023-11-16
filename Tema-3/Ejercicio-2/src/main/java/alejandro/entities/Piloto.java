package alejandro.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Piloto {
    private int driverid;
    private String code;
    private String forename;
    private String surname;
    private Date dob;
    private String nationality;
    private Constructor constructor;
    private String url;

    public Piloto(String code, String forename, String surname, Date dob, String nationality, Constructor constructor, String url) {
        this.code = code;
        this.forename = forename;
        this.surname = surname;
        this.dob = dob;
        this.nationality = nationality;
        this.constructor = constructor;
        this.url = url;
    }
}
