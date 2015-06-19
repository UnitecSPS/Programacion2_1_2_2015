/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exclusivo6PM.prueba5;

/**
 *
 * @author Aula
 */
public class ListaDoble {
    Nodo raiz = null;
    
    public void add(Nodo obj){
        if(raiz == null){
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
        Nodo tmp = raiz;
        while(tmp!=null){
            if(tmp.prev!=null)
                System.out.print(tmp.prev);
            else
                System.out.print("X");
            System.out.print(" <- "+tmp+" -> ");
            if(tmp.next!=null)
                System.out.println(tmp.next);
            else
                System.out.println("X");
            tmp = tmp.next;
        }
    }
    
    public void add(int codeAfter, Nodo obj){
        Nodo tmp = raiz;
        while(tmp!=null){
            if(tmp.code == codeAfter){
                obj.next = tmp.next;
                obj.prev = tmp;
                tmp.next = obj;
                if(obj.next != null)
                    obj.next.prev = obj;
                
                return;
            }
            tmp = tmp.next;
        }
    }
    
    public static void main(String[] args) {
        ListaDoble ld = new ListaDoble();
        ld.add(new Nodo(1));
        ld.add(1,new Nodo(2));
        ld.add(new Nodo(3));
        ld.add(new Nodo(5));
        ld.add(3,new Nodo(4));
        ld.print();
    }
}
