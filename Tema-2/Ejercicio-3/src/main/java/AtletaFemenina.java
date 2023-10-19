import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
    @Data
    @NoArgsConstructor
    @AllArgsConstructor

    @JacksonXmlRootElement(localName = "atleta")
    public class AtletaFemenina{
        private String nombre;
        private List<String> prueba;
        private int edad;
        private String pais;
    }

