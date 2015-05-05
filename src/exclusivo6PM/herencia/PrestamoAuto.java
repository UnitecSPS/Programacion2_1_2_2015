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
public class PrestamoAuto extends Prestamo{
    private double montoSeguro;
    
    public PrestamoAuto(){
        this.tasa = 5;
        deudor= "Bryan";
    }

    public double getMontoSeguro() {
        return montoSeguro;
    }
}
