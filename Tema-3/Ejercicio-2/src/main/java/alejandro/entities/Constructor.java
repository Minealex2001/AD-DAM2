package alejandro.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Constructor {
    private int constructorid;
    private String constructorref;
    private String name;
    private String nationality;
    private URL url;
}
