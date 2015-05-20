/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exclusivo8am.pautas.examen1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class BlockBuster {
    ArrayList<BlockBusterItem> items;
    
    public BlockBuster(){
        items = new ArrayList<>();
    }
    
    public BlockBusterItem busquedaItem(int cod, String tipo){
        for(BlockBusterItem item : items){
            if( cod == item.codigo ){
                if( (tipo.equals("MOVIE") && item instanceof MovieItem) ||
                    (tipo.equals("GAME") && item instanceof VideoGameItem) )
                    return item;
            }
        }
        return null;
    }
    
    public void agregarItem(int co, String n, String ti){
        Scanner lea = new Scanner(System.in);
        if( busquedaItem(co,ti) == null ){
            if( ti.equals("MOVIE")){
                items.add(new MovieItem(co, n, lea.nextDouble()));
            }
            else if(ti.equals("GAME")){
                items.add(new VideoGameItem(co, n, lea.next()));
            }
        }
    }
    
    public void rentar(int co, String ti, int dias){
        BlockBusterItem item = busquedaItem(co,ti);
        if(item!=null){
            System.out.println(item);
            System.out.println("Renta: " + item.pagoRenta(dias));
        }
        else{
            System.out.println("Item No Existe");
        }
    }
    
    public void auditarEstados(){
        auditarEstados(0);
    }

    private void auditarEstados(int pos) {
        if(pos < items.size()){
            if(items.get(pos) instanceof MovieItem)
                ((MovieItem)items.get(pos)).evaluarEstado();
            auditarEstados(pos+1);
        }
    }
}
