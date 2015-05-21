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
public enum DiasDeSemana {
    DOMINGO(0), LUNES(10), MARTES(8), MIERCOLES(7), JUEVES(5), VIERNES(3), SABADO(1);
    
    int valorPeaje;
    
    private DiasDeSemana(int vp){
        valorPeaje = vp;
    }
}
