/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo6PM.herencia;

/**
 *
 * @author Docente 17082011
 */
public class DowncastingPrestamo {
    public static void main(String[] args) {
        //UPCASTING
        Prestamo prem = new PrestamoAuto(1,"Bryan",35000);
        try{
            prem.abono(5000);
        }
        catch(PaymentInvalidException e){
            System.out.println("Error de pago: "+e.getMessage());
        }
        //DOWCASTING 
        
        //INDIRECTO
        PrestamoAuto pauto = (PrestamoAuto)prem;
        pauto.setDescripcionAuto("Nissan Quashqai 2014");
       
        System.out.println(prem);
        
        //DIRECTA
        ((PrestamoAuto)prem).setDescripcionAuto("Audi R8 2015");
        System.out.println(prem);
    }
}
