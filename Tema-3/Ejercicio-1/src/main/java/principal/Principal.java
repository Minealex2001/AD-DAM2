package principal;

import Utilidades.OperacionesCRUDPilotos;
import f1.Piloto;

import java.util.List;

public class Principal {
    public static void main(String[] args) {
        List<Piloto> pilotos = OperacionesCRUDPilotos.leerPilotos();
    }
}
