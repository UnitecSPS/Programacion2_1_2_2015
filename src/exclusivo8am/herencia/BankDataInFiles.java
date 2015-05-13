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
public class BankDataInFiles implements BankActions {

    @Override
    public void createAccount(int num, String n, double s, String t) {
        System.out.println("Recolectar esa info y guardarla en un File");
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
