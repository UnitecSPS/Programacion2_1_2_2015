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
public class BAC {
    public static void main(String[] args) {
        //UPCASTING
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
        
        cuentas.add( new CuentaBancaria(3, "Juan", 10, 0.01) );
        cuentas.add( new CuentaCheques(1,"Kamil",5000) );
        cuentas.add( new CuentaPlazoFijo(2, "Edgar", 500000) );
        
        for(CuentaBancaria cb : cuentas){
            // obj instanceof Clase
            if( cb instanceof CuentaCheques )
                System.out.print("La siguiente cuenta es de cheques: ");
            else if( cb instanceof CuentaPlazoFijo )
                System.out.print("La siguiente cuenta es de plazo fijo: ");
            else
                System.out.println("La siguiente cuenta es de cuenta: ");
            
            System.out.println(cb);
        }
    }
}
