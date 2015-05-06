/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo6PM.herencia;

import java.util.ArrayList;

/**
 *
 * @author Docente 17082011
 */
public class Ficohsa {
    public static void main(String[] args) {
        //UPCASTING
        ArrayList<Prestamo> prestamos = new ArrayList<>();
        prestamos.add( new PrestamoAuto(1,"Bryan",35000) );
        prestamos.add( new PrestamoVivienda(2,"Carlos",350000) );
        prestamos.add( new Prestamo(3,"Alejandro",5000,0.01) );
        

        for(Prestamo prem : prestamos){
            //obj instanceof Clase 
            if( prem instanceof PrestamoVivienda )
                System.out.print("VVIENDA ");
            else if( prem instanceof PrestamoAuto )
                System.out.println("AUTO ");
            else
                System.out.println("PAPA ");
            
            System.out.println(prem);
        }
    }
}
