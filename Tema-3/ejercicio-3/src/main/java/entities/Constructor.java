package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.net.URL;

@Data
@NoArgsConstructor
public class Constructor {
    String constructorref;
    String name;
    String nationality;
    String url;

    public Constructor(String constructorref, String name, String nationality, String url) {
        this.constructorref = constructorref;
        this.name = name;
        this.nationality = nationality;
        this.url = url;
    }
}
