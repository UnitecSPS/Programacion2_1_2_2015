/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo6PM.prueba3;

/**
 *
 * @author Aula
 */
public class ColeccionTexto {
    static String textos[] = {"Messi", "Neymar", "Suarez"};
    
    static void addTextAt(String newText, int pos){
        try{
            if(newText == null || newText.equals("") )
                throw new ValorMaloException();
            textos[pos] += newText;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error: " + e);
        }
    }
    
    public static void main(String[] args) {
        try{
            addTextAt("El Crack", 0);
            addTextAt("El Mordelon", 2);
            addTextAt("Jr", 3);
            addTextAt(null, 0);
        }
        catch(ValorMaloException e){
            System.out.println(e.getMessage());
        }
        
        for(String t : textos)
            System.out.println(t);
   }
}
