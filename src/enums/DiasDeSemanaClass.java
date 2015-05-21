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
public class DiasDeSemanaClass {
    static final DiasDeSemanaClass DOMINGO = new DiasDeSemanaClass(0,"DOMINGO",0);
    static final DiasDeSemanaClass LUNES = new DiasDeSemanaClass(1,"LUNES",10);
    static final DiasDeSemanaClass MARTES = new DiasDeSemanaClass(2,"MARTES",8);
    static final DiasDeSemanaClass MIERCOLES = new DiasDeSemanaClass(3,"MIERCOLES",7);
    static final DiasDeSemanaClass JUEVES = new DiasDeSemanaClass(4, "JUEVES",5);
    static final DiasDeSemanaClass VIERNES = new DiasDeSemanaClass(5, "VIERNES",3);
    static final DiasDeSemanaClass SABADO = new DiasDeSemanaClass(6, "SABADO",1);
    
    private int ordinal;
    private String name;
    public int valorPeaje;
    
    public DiasDeSemanaClass(int ord,String txt,int vp){
        ordinal = ord;
        name = txt;
        valorPeaje = vp;
    }
    
    public static DiasDeSemanaClass valueOf(String name){
        switch(name){
            case "DOMINGO":
                return DOMINGO;
            case "LUNES":
                return LUNES;
            default:
                System.out.println("ERROR! NO EXISTE ESA CONSTANT");
                return null;
        }
    }
    
    public int ordinal(){
        return ordinal;
    }
    
    public String name(){
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
