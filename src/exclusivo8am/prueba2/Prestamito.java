/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exclusivo8am.prueba2;

/**
 *
 * @author Docente 17082011
 */
public class Prestamito extends Prestamo implements Pagable {
    private double balance;
    
    public Prestamito(int n,String nom,double mon){
        super(n,nom,mon);
        balance = monto;
    }
    
    @Override
    double getBalance() {
        return balance;
    }

    @Override
    public void pay(double m) {
        
        if(m > balance)
            m = balance;
        balance -= m;
    }
    
}
