/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
/**
 *
 * @author Carlos
 */
public class ArrayLists {
    public static void main(String[] args) {
        ArrayList<String> arreglo = new ArrayList<>();
        
        //guardo datos en el arreglo
        arreglo.add("Hola");
        arreglo.add("Mundo");
        
        //recorrer el arreglo
        
        for(String cad : arreglo)
        {
            System.out.println(cad);
        }
        
        for(int p = 0; p < arreglo.size(); p++)
        {
            System.out.println("-" + arreglo.get(p));
        }
        
        //modificar el valor de una posicion
        
        arreglo.set(0, "Que Onda");
        
        if( arreglo.contains("Mundo"))
            System.out.println("Si contiene a Mundo");
        
        arreglo.add(1, "Que Contas");
        for(String cad: arreglo)
            System.out.println("-" +cad);
    }
}
