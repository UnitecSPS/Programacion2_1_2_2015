/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exclusivo8am.herencia;

import java.util.ArrayList;

/**
 *
 * @author Docente 17082011
 */
public class BankDataInMemory implements BankActions {
    
    ArrayList<CuentaBancaria> cuentas = new ArrayList<>();

    @Override
    public void createAccount(int num, String n, double s, String tipo) {
        if(tipo.equals("CHEQUE"))
            cuentas.add(new CuentaCheques(num, n, s));
        else if(tipo.equals("PLAZOFIJO"))
            cuentas.add(new CuentaPlazoFijo(num, n, s));
        else
            cuentas.add(new CuentaBancaria(num, n, s, 0.03));
    }

    @Override
    public CuentaBancaria searchAccount(int num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deposit(int num, double m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void print() {
        for(CuentaBancaria cb : cuentas)
            System.out.println("-" + cb);
    }
    
}
