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
    
    public PrestamoAuto(int n, String d, double m){
        super(n, d, m, 0.08);
        montoSeguro = monto * 0.5;
        balance += montoSeguro;
    }
    
    public PrestamoAuto(){
        this(-1,"pepito",0);
    }
    

    public double getMontoSeguro() {
        return montoSeguro;
    }
}
