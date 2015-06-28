/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pauta.examenlab2;

public class HashTable {
    Entry raiz;
    
    public void add(int cod, long pos){
        if(raiz==null){
            raiz=new Entry(cod, pos);
        }
        else{
            Entry tmp=raiz;
            while(tmp.next!=null){
                tmp=tmp.next;
            }
            tmp.next=new Entry(cod, pos);
        }
    }
    
    public void remove(int cod){
        if(raiz!=null){
            if(raiz.codigo==cod){
                raiz=raiz.next;
            }
            else{
                Entry tmp=raiz;
                while(tmp.next!=null){
                    if(tmp.next.codigo==cod){
                        tmp.next=tmp.next.next;
                        break;
                    }
                    tmp=tmp.next;
                }
            }
        }   
    }
    
    public long search(int cod){
       Entry tmp = raiz;
       while(tmp!=null){
           if(tmp.codigo == cod)
               return tmp.pos;
           tmp=tmp.next;
       }
       return -1;
    }
}
