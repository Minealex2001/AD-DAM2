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
    private URL url;
}
