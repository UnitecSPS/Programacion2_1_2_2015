/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errores;

import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class ExceptionesTest {
    public static void main(String[] args) {
        System.out.println("Iniciando Main");
        A();
        System.out.println("Finalizando Main");
    }

    private static void A() {
        System.out.println("Iniciando A");
        try{
            B();
            System.out.println("Boooo");
        }
        catch(Exception x){
            System.out.println("Error");
        }
            
        System.out.println("Finalizando A");
    }
    
    private static void B() {
        System.out.println("Iniciando B");
        Scanner lea = new Scanner(System.in);
        int x = lea.nextInt();
        int nums[]= { 5,6,7};
        System.out.println("Res: " + nums[x]/x);
        System.out.println("Finalizando B");
    }
}
