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
public abstract class Prestamo {
    protected int numero;
    protected String nombre;
    protected double monto;

    public Prestamo(int numero, String nombre, double monto) {
        this.numero = numero;
        this.nombre = nombre;
        this.monto = monto;
    }
    
    abstract double getBalance();
}
