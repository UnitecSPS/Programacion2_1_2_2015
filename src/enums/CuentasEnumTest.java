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
public class CuentasEnumTest {
    public static void main(String[] args) {
        
        System.out.println("Tipos Disponibles");
        System.out.println("-----------------");
        for(TipoCuenta t : TipoCuenta.values())
            System.out.println("-"+t+" con rate: " + t.rate);
        System.out.println("-----------------");
        
        TipoCuenta tc = TipoCuenta.PLANILLA;
        System.out.println("Tipo: " + tc);
        System.out.println("Ordinal: " + tc.ordinal());
        
        TipoCuentaClass tc2 = TipoCuentaClass.CHEQUES;
        System.out.println("Tipo2: " + tc2);
        System.out.println("Ordinal2: " + tc2.ordinal());
        
        //pedir del teclado y sacar un elemento del enum
        String tipo = "planilla".toUpperCase();
        tc = TipoCuenta.valueOf(tipo);
        System.out.println("Tipo: " + tc);
        tc2 = TipoCuentaClass.valueOf("PLAZO");
        System.out.println("Tipo2: " + tc2);
        
        //comparar elementos del enum
        if( tc == TipoCuenta.AHORRO )
            System.out.println("ES AHORRO!");
        else
            System.out.println("NO ES AHORRO!");
        
        switch(tc){
            case PLANILLA:
                System.out.println("ES PLANILLA!");
                break;
            default:
                System.out.println("NO ES PLANILLA!");
        }
        
        if(tc.ordinal() == 3){
            System.out.println("ES PLANILLA!");
        }
        else{
            System.out.println("NO ES PLANILLA!");
        }
        
        System.out.println("rate de la tc: " + tc.rate);
        System.out.println("rate de Ahorro: " + TipoCuenta.AHORRO.rate);
    }
}
