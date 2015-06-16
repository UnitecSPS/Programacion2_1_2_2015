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
public class Lista {
    private Nodo raiz = null;
    
    /**
     * Agregar el obj Nodo al final de la lista
     * @param obj Nodo a agregar
     */
    public void add(Nodo obj){
        if(raiz==null)
            raiz = obj;
        else{
            Nodo viajero = raiz;
            while(viajero.next != null)
                viajero = viajero.next;
            viajero.next = obj;
        }
    }
    
    /**
     * Recorra TODA la lista e imprima los nodos
     */
    public void print(){
        
    }
}
