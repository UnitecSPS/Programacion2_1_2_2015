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
public class TestNodo {
    public static void main(String[] args) {
        System.out.println("PRINCIPIO BASICO DEL MANEJO DE MEMORIA");
        Nodo a = new Nodo("Juan");
        Nodo b = a;
        
        b.nombre = "Kamil";
        
        System.out.println(a.nombre);
        System.out.println(b.nombre);
        
        if( b == a )
            System.out.println("Estan en el mismo espacio");
        
        String c1 = "hola";
        String c2 = c1;
        c2 = "Pepe";
        
        if(c1==c2)
            System.out.println("Cadenas Iguales");
       
    }
}
