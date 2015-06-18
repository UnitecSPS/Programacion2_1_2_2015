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
public class FundamentoBasico {
    public static void main(String[] args) {
        Prestamo a = new Prestamo("Alvaro", 5000);
        Prestamo b = a;
        
        b.cliente = "Douglas";

        System.out.println(a);
        System.out.println(b);
        
        int x = 5;
        int y = x;
        y = 10;
        
        System.out.println(x);
        System.out.println(y);
        
        if(a == b)
            System.out.println("Si, estan en el mismo espacio");
    
        String c1 = "hola";
        String c2 = "hola";
        
        if( c1 == c2 )
            System.out.println("Son IguaLES");
    }
}
