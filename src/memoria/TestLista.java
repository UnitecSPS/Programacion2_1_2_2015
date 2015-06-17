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
public class TestLista {
    public static void main(String[] args) {
        Lista list = new Lista();
        list.add(new Nodo("Juan"));
        list.add(new Nodo("Kamil"));
        list.add(new Nodo("Jonathan"));
        list.add(new Nodo("Cris"));
        list.print();
        
        list.add("Kamil", new Nodo("Edgard"));
        list.add("Cris", new Nodo("Victor"));
        list.add("Messi", new Nodo("Lio"));
        System.out.println("\nDESPUES DE AGREGAR DESPUES\n---------");
        list.print();
        
        list.remove("Juan");
        list.remove("Jonathan");
        list.remove("Victor");
        list.remove("Messi");
        System.out.println("\nDESPUES DE BORRAR\n---------");
        list.print();
        
    }
}
