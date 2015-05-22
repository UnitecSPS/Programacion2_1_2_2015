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
public class TipoCuentaClass {
    private int ordinal;
    private String name;
    
    static final TipoCuentaClass AHORRO = new TipoCuentaClass(0,"AHORRO");
    static final TipoCuentaClass CHEQUES = new TipoCuentaClass(1,"CHEQUES");
    static final TipoCuentaClass PLAZO = new TipoCuentaClass(2,"PLAZO");
    static final TipoCuentaClass PLANILLA = new TipoCuentaClass(3,"PLANILLA");
    
    private TipoCuentaClass(int or, String n){
        ordinal = or;
        name = n;
    }
    
    public static TipoCuentaClass valueOf(String name){
        switch(name){
            case "AHORRO":
                return AHORRO;
            case "CHEQUES":
                return CHEQUES;
            case "PLAZO":
                return PLAZO;
            case "PLANILLA":
                return PLANILLA;
            default:
                return null;
        }
    }
    
    public final int ordinal(){
        return ordinal;
    }
    
    public final String name(){
        return name;
    }
    
    @Override
    public String toString(){
        return name;
    }
}
