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
public class TestDobleLista {
    public static void main(String[] args) {
        ListaDoble list = new ListaDoble();
        list.add(new Nodo(1));
        list.add(new Nodo(2));
        list.add(new Nodo(3));
        list.add(new Nodo(4));
         list.print();
        list.remover(1);
        list.remover(3);
        list.remover(4);
        list.remover(2);
        list.print();
        
    }
}
