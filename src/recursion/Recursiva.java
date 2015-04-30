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
    public int sumaUp(int n){
        if(n>1)
            return sumaUp(n-1)+n;
        return 1;
    }
    
    public int sumaDown(int n){
        return sumaDown(n,0);
    }
    
    private int sumaDown(int n, int suma){
        if(n>=1)
            return sumaDown(n-1, suma+n);
        return suma;
    }
    
    /**
     * Calcular la potencia
     * @param b Base
     * @param e Exponente
     * @return La potencia calculada
     */
    public int powUp(int b, int e){
        if(e>0)
            return powUp(b, e-1)*b;
        return 1;
    }
    //valor inicial del acum es 1
    public int powDown(int b, int e, int acum){
        if(e>0){
            return powDown(b, e-1, acum*b);
        }
        return acum;
    }
    
    public int factorial(int n){
        if(n>1)
            return factorial(n-1)*n;
        return 1;
    }
    
    public int mcdUp(int n1, int n2, int d){
        if(n1 >= d && n2 >= d){
            if(n1 % d == 0 && n2 % d == 0){
                return mcdUp(n1/d, n2/d, d)*d;
            }
            return mcdUp(n1, n2, d+1);
        }
        return 1;
    }
    
    public int mcdDown(int n1,int n2){
        return mcdDown(n1,n2,2,1);
    }
    
    private int mcdDown(int n1, int n2, int d, int res){
        if(n1 >= d && n2 >= d){
            if(n1 % d == 0 && n2 % d == 0){
                return mcdDown(n1/d, n2/d, d, res * d);
            }
            return mcdDown(n1, n2, d+1, res);
        }
        return res;
    }
    
    public int mcdEuclides(int n1, int n2){
        if(n2 == 0)
            return n1;
        return mcdEuclides(n2, n1 % n2);
    }
    /**
     * Funcion recursiva que retorna true si la cad de parametro es
     * palindromo o no.
     * @param cad Cadena a evaluar
     * @return true si lo es o false si no.
     */
    public boolean palindromo(String cad){
        return palindromo(cad, 0, cad.length()-1);
    }

    private boolean palindromo(String cad, int inicio, int fin) {
        if(inicio<fin){
            if(cad.charAt(inicio)== cad.charAt(fin))
                return palindromo(cad, inicio+1, fin-1);
            return false;
        }
        return true;
    }
    
    /**
     * Imprime una piramide
     * @param filas Cantidad de Filas necesarias
     */
    public void piramide(int filas){
        piramide(filas, 1, 1);
    }

    private void piramide(int filas,int fila, int col) {
        if(fila <= filas)
        {
            if(col <= fila)
            {
                System.out.print("*");
                piramide(filas, fila, col + 1);
            }
            else
            {
                System.out.println("");
                piramide(filas, fila + 1, 1);
            }
        }
    }
    
    /**
     * Ver si un numero es primo o no
     * @param n Numero a evaluar
     * @return true si es primo o false si no
     */
    public boolean primo(int n){
        return primo(n,2);
    }

    private boolean primo(int n, int d) {
        if(n==1)
            return false;
        else if(d < n){
            if( n % d == 0 )
                return false;
            return primo(n, d+1);
        }
        return true;
    }
}
