/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

/**
 *
 * @author Aula
 */
public class Nodo {
    public String nombre;
    public Nodo next;

    public Nodo(String nombre) {
        this.nombre = nombre;
        next = null;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
}
