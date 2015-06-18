/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo8am.prueba5;

/**
 *
 * @author Aula
 */
public class Nodo {
    public int codigo;
    public Nodo next, prev;

    public Nodo(int h) {
        this.codigo = h;
        next = null;
        prev=null;
    }
    
    @Override
    public String toString(){
        return ""+codigo;
    }
}

