/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recursion;

import java.util.Date;

/**
 *
 * @author Docente 17082011
 */
public class TestRecursion {
    public static void main(String[] args) {
        Date inicio, fin;
        Recursiva re = new Recursiva();
    
        re.print(6);
        System.out.println("\nSuma: " + re.sumaUp(5));
        System.out.println("Suma: " + re.sumaDown(5));
        
        inicio = new Date();
        System.out.println("Pow: " + re.powUp(2,4));
        System.out.println("Pow Down:" + re.powDown(2, 4, 1));
        fin = new Date();
        System.out.println("Se tard: " + (fin.getTime()-inicio.getTime()) +
                " ms");
        
        System.out.println("Factorial: " + re.factorial(24));
        System.out.println("MCD(36,24): " + re.mcdDown(36, 24));
        
        re.piramide(6);
        System.out.println("Fiboracci" + re.Fibo(8));
    }
}
