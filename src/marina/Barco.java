/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package marina;

import java.util.Date;

/**
 *
 * @author Docente 17082011
 */
public abstract class Barco {
    protected String name;
    protected Date fecha;
    
    public Barco(String n){
        name = n;
        fecha = new Date();
    }

    public String getName() {
        return name;
    }

    public Date getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "name=" + name + ", fecha=" + fecha;
    }
    
    public abstract void agregarElemento();
    public abstract double vaciarCobrar();
}
