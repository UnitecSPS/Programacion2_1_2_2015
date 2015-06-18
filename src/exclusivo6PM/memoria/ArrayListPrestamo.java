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
        if (!isEmpty()){
            if(root.cliente.equals(nombre)){
                root= root.next;
                return true;
            }
            Prestamo mochilero= root;
            while(mochilero.next!=null){
                if(mochilero.next.cliente.equals(nombre)){
                    mochilero.next= mochilero.next.next;
                    return true;
                }
                mochilero= mochilero.next;
            }
        }
        return false;
    }
    
    /**
     * Voy a agregar un nuevo prestamo despues del 
     * prestamo cuyo cliente se llama igual que after
     * @param after Cliente a buscar
     * @param obj El prestamo Nuevo
     */
    public void add(String after, Prestamo obj){
        if(obj == null) return;
        Prestamo mochilero = root;
        while(mochilero != null){
            if(mochilero.cliente.equals(after)){
                obj.next = mochilero.next;
                mochilero.next = obj;
                return;
            }
            mochilero = mochilero.next;
        }
    }
    
    /**
     * Limpia toda la lista
     */
    public void clear(){
        root = null;
    }
    
    /**
     * Retorna true si hay un prestamo con ese cliente
     * o no
     * @param cliente
     * @return 
     */
    public boolean contains(String cliente){
        return false;
    }
    
    /**
     * Retorna la cantidad total de prestamos en el listado
     * @return 
     */
    public int size(){
        return 0;
    }
    
    /**
     * Retorna el objeto prestamo que esta en esa posicion
     * comenzando desde cero.
     * Si la pos es negativa o mayor que size, se lanza
     * IndexOutOfBoundException
     * @param pos
     * @return 
     */
    public Prestamo get(int pos){
        return null;
    }
}
