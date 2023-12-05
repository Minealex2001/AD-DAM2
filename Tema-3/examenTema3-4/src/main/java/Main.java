import entities.Cliente;
import entities.Cuenta;
import utils.CRUDOperation;

public class Main {
    public static void main(String[] args) {
        CRUDOperation crudOperation = new CRUDOperation();
        Cliente cliente1 = new Cliente(15, "12345678A", "Paco", "Perez", "Español", "123456789", "aaaa@aaaa.com", "paco", "paco");
        Cliente cliente2 = new Cliente(15, "12345678A", "Pepe", "Perez", "Brasil", "123456789", "aaaa@aaaa.com", "pepe", "1234");
        Cuenta cuenta1 = new Cuenta("ES123456789123456789", 100, cliente1.getId());
        Cuenta cuenta2 = new Cuenta("ES987654321123456789", 20, cliente2.getId());

        crudOperation.crearCliente(cliente1);
        crudOperation.leerTodo();
        crudOperation.modificarCliente(cliente2);
        crudOperation.insertarCuenta(cuenta1, cliente2);
        crudOperation.modificarCuenta(cuenta1, cuenta2);
        crudOperation.borrarCliente(cliente2.getId());
        crudOperation.borrarCuenta(cuenta2);
    }
}
