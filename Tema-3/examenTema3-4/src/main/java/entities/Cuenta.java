package entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cuenta {
    int accountid;
    String iban;
    int balance;
    int clientid;

    public Cuenta(String iban, int balance, int clientid) {
        this.iban = iban;
        this.balance = balance;
        this.clientid = clientid;
    }
}
