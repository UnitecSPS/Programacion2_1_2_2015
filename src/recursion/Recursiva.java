/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recursion;

/**
 *
 * @author Docente 17082011
 */
public class Recursiva {
    /**
     * Imprime los numeros desde 1 hasta N
     * @param n El limite de la impresion
     */
    public void print(int n){
      //  System.out.println("Entrando a print("+n+")");
        if(n>1)
            print(n-1);
        System.out.print(n+" ");
       // System.out.println("finalizando print("+n+")");
    }
    
    /**
     * METODO RECURSIVO: UP
     * Retorna la suma de los numeros desde 1 HASTA n
     * @param n el limite de la suma
     * @return la suma de los numeros 
     */
    public int suma(int n){
        if(n>1)
            return suma(n-1)+n;
        return 1;
    }
}
