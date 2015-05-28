/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exclusivo8am.prueba3;

/**
 *
 * @author Docente 17082011
 */
public class ColeccionEntera {
    static private int numeros[] = new int[10];
    
    public static void agregar(Object valor,int pos){
        if(!(valor instanceof Integer))
            throw new ValorMaloException();
        
        try{
            numeros[pos] = (int)valor;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        agregar(5,0);
        agregar(13,4);
        agregar(13,10);
        try{
            agregar("Hola",2);
        }
        catch(ValorMaloException e){
            System.out.println(e);
        }
        for(int x : numeros)
            System.out.println(x);
    }
}
