/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enums;

/**
 *
 * @author Docente 17082011
 */
public class TestEnum {
    public static void main(String[] args) {
        DiasDeSemana dia = DiasDeSemana.MIERCOLES;
        DiasDeSemanaClass dia2 = DiasDeSemanaClass.SABADO;
        
        System.out.println("Dia: " + dia);
        System.out.println("Valor Ordinal: " + dia.ordinal());
        
        System.out.println("Dia2: " + dia2);
        System.out.println("Valor Ordinal: " + dia2.ordinal());
        
        //si lo quieren ingresar del teclado
        String d = "LUNES".toUpperCase();
        dia = DiasDeSemana.valueOf(d);
        System.out.println("Dia: " + dia);
        System.out.println("Valor Ordinal: " + dia.ordinal());
        
        //si lo quieren comparar
        if( dia == DiasDeSemana.VIERNES)
            System.out.println("Es Viernes");
        else
            System.out.println("NO es Viernes");
        
        switch(dia){
            case DOMINGO:
                System.out.println("Es Domingo");
                break;
            case LUNES:
                System.out.println("Es Lunes");
                break;
            default:
                System.out.println("No es Domingo Ni Lunes");
        }
        
        if(dia.ordinal() == 1){
            System.out.println("ES LUNES");
        }
        else{
            System.out.println("NO ES LUNES");
        }
        
        System.out.println("Te van a cobrar de peaje: Lps. " + dia.valorPeaje);
        System.out.println("El Sabado cobran: " + 
                DiasDeSemana.SABADO.valorPeaje);
    }
}
