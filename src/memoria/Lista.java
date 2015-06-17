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
        if(isEmpty())
            raiz = obj;
        else{
            Nodo viajero = raiz;
            while(viajero.next != null)
                viajero = viajero.next;
            viajero.next = obj;
        }
    }
    
    /**
     * Agregar un nuevo nodo DESPUES del nodo que contenga el nombre que sea
     * igua a AFTER
     * @param after El nombre a buscar
     * @param obj 
     */
    public void add(String after, Nodo obj){
        Nodo viajero = raiz;
        while(viajero!=null){
            if(viajero.nombre.equals(after)){
                obj.next=viajero.next;
                viajero.next=obj;
                break;
            }
            else
                viajero = viajero.next;
        }
    }
    
    /**
     * Recorra TODA la lista e imprima los nodos
     */
    public void print(){
        Nodo viajero = raiz;
        while(viajero != null){
            System.out.println(viajero);
            viajero = viajero.next;
        }
    }
    
    public boolean isEmpty(){
        return raiz == null;
    }
    
    /**
     * Busca el nodo con ese nombre, si lo encuentra, lo 
     * remueve de la lista
     * @param nombre
     * @return True si lo pudo borrar o no
     */
    public boolean remove(String nombre){
        if(!isEmpty()){
            if(raiz.nombre.equals(nombre)){
                raiz = raiz.next;
                return true;
            }
            else{
                Nodo viajero = raiz;
                while(viajero.next != null){
                    if(viajero.next.nombre.equals(nombre)){
                        viajero.next = viajero.next.next;
                        return true;
                    }
                    else
                        viajero = viajero.next;
                }
            }
        }
        return false;
    }
    
    /**
     * Agregaria al final de la lista cada nodo que esta
     * dentro de ese arreglo
     * @param nodos 
     */
    public void addAll(Nodo nodos[]){
        
    }
    
    public void clear(){
        raiz = null;
    }
    
    /**
     * Retornar true si existe un nodo con ese nombre
     * @param n
     * @return 
     */
    public boolean contains(String n){
        return false;
    }
    
    /**
     * Retorna un nodo de la lista que coincida con ese nombre
     * @param nombre
     * @return 
     */
    public Nodo get(String nombre){
        return null;
    }
    
    /**
     * Retorna la cantidad de nodos que tiene la lista
     * @return 
     */
    public int size(){
        return 0;
    }
    
    /**
     * Cambiamos el nombre del nodo que tenga oldName
     * @param oldName
     * @param newName 
     */
    public void set(String oldName, String newName){
        
    }
    
    /**
     * Retorna toda la lista pero en modo arreglo unidimensional
     * @return 
     */
    public Nodo[] toArray(){
        return null;
    }
}
