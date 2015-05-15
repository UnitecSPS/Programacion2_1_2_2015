/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo6PM.prueba2;

/**
 *
 * @author Docente 17082011
 */
public abstract class Collection {
    protected String title;
    protected String tipo;

    public Collection(String title, String tipo) {
        this.title = title;
        this.tipo = tipo;
    }
    
    abstract void fill();
}
