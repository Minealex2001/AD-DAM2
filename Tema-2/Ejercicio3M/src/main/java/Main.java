import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Path ficheroXML = Path.of(".","src","main","resources","atletas.xml");

        List<String> prueba = new ArrayList<>();
        prueba.add("100m");
        prueba.add("200m");
        AtletaFemenina atleta1 = new AtletaFemenina("Maria", prueba,20, "España");
        prueba.clear();
        prueba.add("500m");
        prueba.add("1000m");
        AtletaFemenina atleta2 = new AtletaFemenina("Laura", prueba, 25, "Francia");
        List<AtletaFemenina> atletas = List.of(atleta1, atleta2);
        ListaAtletas listaAtletas = new ListaAtletas(atletas);

        escibirXml(listaAtletas, ficheroXML);

        List<AtletaFemenina> listaXML = leerXml(ficheroXML);

    }

    public static void escibirXml(ListaAtletas lista, Path ruta) throws IOException {
        Files.deleteIfExists(ruta);
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.writeValue(ruta.toFile(), lista);
    }

    public static List<AtletaFemenina> leerXml(Path ruta) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        String xml = Files.readString(ruta);
        return xmlMapper.readValue(xml, ListaAtletas.class).getAtletas();
    }
}
