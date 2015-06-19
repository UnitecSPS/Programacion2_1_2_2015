/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo6PM.prueba5;

/**
 *
 * @author Aula
 */
public class Nodo {
    int code;
    Nodo next=null, prev=null;

    public Nodo(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "" + code;
    }
    
    
}
