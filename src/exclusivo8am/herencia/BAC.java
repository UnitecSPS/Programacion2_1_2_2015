/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exclusivo8am.herencia;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Docente 17082011
 */
public class BAC {
    public static void main(String[] args) {
        //UPCASTING
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
        
        cuentas.add( new CuentaBancaria(3, "Juan", 10, 0.01) );
        cuentas.add( new CuentaCheques(1,"Kamil",5000) );
        cuentas.add( new CuentaPlazoFijo(2, "Edgar", 500000) );
        
        System.out.println(((CuentaPlazoFijo)cuentas.get(2)).getPlazoFin().getTime());
        
        for(CuentaBancaria cb : cuentas){
            cb.quienSoy();
        }
        
        System.out.println("\n----------------------------\n");
        
        for(CuentaBancaria cb : cuentas){
            try {
                cb.depositar(500);
            } catch (InvalidAmountException ex) {
                
            }
            // obj instanceof Clase
            if( cb instanceof CuentaCheques )
                System.out.print("La siguiente cuenta es de cheques: ");
            else if( cb instanceof CuentaPlazoFijo ){
                ((CuentaPlazoFijo)cb).setPlazoFin("11/12/2018");
                System.out.print("La siguiente cuenta es de plazo fijo: ");
            }else
                System.out.println("La siguiente cuenta es de cuenta: ");
            
            
            System.out.println(cb);
        }
    }
}
