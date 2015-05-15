/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package laboratorio.tg2;

import java.util.Date;

/**
 *
 * @author Docente 17082011
 */
public abstract class Empleado {
    protected int codigo;
    protected String nombre;
    protected Date fecha;
    protected double salario;

    public Empleado(int codigo, String nombre, double salario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.salario = salario;
        fecha = new Date();
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "codigo=" + codigo + ", nombre=" + nombre;
    }
    
    abstract double pago(); 
}
