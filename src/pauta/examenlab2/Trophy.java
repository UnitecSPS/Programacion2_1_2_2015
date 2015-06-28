/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pauta.examenlab2;

public enum Trophy {
    PLATINO(5), ORO(3), PLATA(2), BRONCE(1);
    
    int puntos;
    
    private Trophy(int p){
        puntos=p;
    }
}
