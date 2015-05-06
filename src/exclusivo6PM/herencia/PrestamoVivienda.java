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
public class PrestamoVivienda extends Prestamo {
    private double gastoCierre;

    public PrestamoVivienda(int numero, String deudor, double monto) {
        super(numero, deudor, monto, 0.1);
        gastoCierre = 30000;
    }

    public double getGastoCierre() {
        return gastoCierre;
    }
    
}
