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
        if( raiz == null){
            raiz = obj;
        }
        else{
            Nodo tmp = raiz;
            while(tmp.next != null)
                tmp = tmp.next;
            tmp.next = obj;
            obj.prev = tmp;
        }
    } 
    
    public void print(){
        Nodo tmp = raiz, cola=null;
        System.out.println("De Raiz a la Cola");
        while(tmp!=null){
            System.out.println(tmp);
            cola = tmp;
            tmp = tmp.next;
        }
        System.out.println("De la cola a la Raiz");
        while(cola!=null){
            System.out.println(cola);
            cola = cola.prev;
        }
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
