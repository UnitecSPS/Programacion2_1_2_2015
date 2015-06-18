/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo6PM.memoria;

/**
 *
 * @author Aula
 */
public class Prestamo {
    public String cliente;
    public double monto;
    public Prestamo next;
    
    public Prestamo(String c, double m){
        cliente = c;
        monto = m;
        next = null;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "cliente=" + cliente + ", monto=" + monto + '}';
    }
    
    
}
