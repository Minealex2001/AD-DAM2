import java.util.List;

public class AtletaFemenina {
    private String nombre;
    private List<String> prueba;
    private int edad;
    private String pais;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor

    @JacksonXmlRootElement(localName = "atleta")
    public class AtletaFemenina{
        @JacksonXmlProperty{isAttribute = true}
        private String nombre;
        @JacksonXmlProperty{isAttribute = true}
        private List<String> prueba;
        @JacksonXmlProperty{isAttribute = true}
        private int edad;
        @JacksonXmlProperty{isAttribute = true}
        private String pais;

    }



}
