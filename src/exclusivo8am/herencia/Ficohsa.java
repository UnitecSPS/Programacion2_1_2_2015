/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exclusivo8am.herencia;

/**
 *
 * @author Docente 17082011
 */
public class Ficohsa {
    public static void main(String[] args) {
        BankActions actions = new BankDataInFiles();
        
        System.out.println("1-Crear Cuenta");
        int op = 1;
        
        switch(op){
            case 1:
                actions.createAccount(1, "Nombre", 5000, "CHEQUE");
        }
    }
}
