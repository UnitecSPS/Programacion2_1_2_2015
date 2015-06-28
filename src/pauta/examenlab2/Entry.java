/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pauta.examenlab2;

public class Entry {
    int codigo;
    long pos;
    Entry next;
    
    public Entry(int codigo, long pos){
        this.codigo=codigo;
        this.pos=pos;
        next = null;
    }
}
