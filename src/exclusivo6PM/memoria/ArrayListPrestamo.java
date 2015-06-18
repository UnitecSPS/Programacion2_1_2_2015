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
public class ArrayListPrestamo {
    private Prestamo root = null;
    
    public boolean isEmpty(){
        return root == null;
    }
    
    public void add(Prestamo obj){
        if(isEmpty())
            root = obj;
        else{
            Prestamo mochilero = root;
            while(mochilero.next != null)
                mochilero = mochilero.next;
            mochilero.next = obj;
        }
    }
    
    public void print(){
        Prestamo mochilero = root;
        while(mochilero!=null){
            System.out.println(mochilero);
            mochilero = mochilero.next;
        }
    }
    
    /**
     * Remueve el prestamo que tenga ese nombre de cliente
     * de la lista enlazada
     * @param nombre El nombre a buscar
     * @return True si lo pudo eliminar o no
     */
    public boolean remove(String nombre){
        
    }
}
