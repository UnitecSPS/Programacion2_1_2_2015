/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo6PM.pautas.examen1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class Tigo {
    ArrayList<Plan> planes = new ArrayList<>();
    
    public boolean busqueda(int num, String id){
        return busqueda(num, id, 0);
    }

    private boolean busqueda(int num, String id, int pos) {
        if(pos < planes.size()){
            Plan p = planes.get(pos);
            if( p.getNumero() == num || p.getId().equals(id))
                return true;
            return busqueda(num, id, pos+1);
        }
        return false;
    }
    
    public void addPlan(int nt, String no, String tipo){
        Scanner lea = new Scanner(System.in);
        
        if( tipo.equals("IPHONE")){
            String correo = lea.next();
            if(!busqueda(nt, correo))
                planes.add(new PlanIphone(nt, no, correo));
        }
        else if( tipo.equals("BLACKBERRY")){
            String pin = lea.next();
            if(!busqueda(nt, pin))
                planes.add(new PlanBlackberry(nt, no, pin));
        }
        
    }
    
    public double pagoPlan(int nt, int mins, int msgs){
        for(Plan p : planes){
            if(p.getNumero() == nt){
                return p.pagoMensual(mins, msgs);
            }
        }
        return 0;
    }
    
    public void AddAmigo(int nt, String pin){
        for(Plan p : planes){
            if(p.getNumero() == nt && p instanceof PlanBlackberry)
                ((PlanBlackberry)p).addPinAmigo(pin);
        }
    }
    
    public void list(){
        int pi=0, pb=0;
        for(Plan p : planes){
            if(p instanceof PlanIphone)
                pi++;
            else if( p instanceof PlanBlackberry)
                pb++;
        }
        System.out.println("pi " + pi + " pb " + pb);
    }
}
