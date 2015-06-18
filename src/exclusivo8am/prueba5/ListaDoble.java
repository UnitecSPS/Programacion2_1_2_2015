/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo8am.prueba5;

/**
 *
 * @author Aula
 */
public class ListaDoble {
    Nodo raiz = null;
    
    public void add(Nodo obj){
        
    }
    
    public boolean remover(int c){
        if( raiz != null){
            if(raiz.codigo == c){
                raiz = raiz.next;
                if( raiz != null )
                    raiz.prev = null;
                return true;
            }
            //no es la raiz
            Nodo tmp = raiz;
            while(tmp.next!=null){
                if(tmp.next.codigo == c){
                    tmp.next = tmp.next.next;
                    if(tmp.next != null)
                        tmp.next.prev = tmp;
                    return true;
                }
                tmp = tmp.next;
            }
        }
        return false;
    }
}
