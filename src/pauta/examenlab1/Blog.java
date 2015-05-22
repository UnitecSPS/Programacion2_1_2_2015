/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pauta.examenlab1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mac
 */
public class Blog {
    static ArrayList<User> usuarios = new ArrayList<>();
    static User currentUser = null;
    static ArrayList<String> posts = new ArrayList<>();
    static Scanner lea= new Scanner(System.in);
    
    public static void main(String[] args) {
        //agrego el user por default
        usuarios.add(new AdminUser("admin","admin"));
        int op;
        
        do{
            System.out.println("1- Login");
            System.out.println("2- Crear Post");
            System.out.println("3- Agregar usuario");
            System.out.println("4- Ver Posts");
            System.out.println("5- Eliminar Post");
            System.out.println("6- Logout");
            System.out.println("7- Exit");
            System.out.println("Escoja Opcion: ");
            op = lea.nextInt();
            
            switch(op){
                case 1:
                    login();
                    break;
                case 2:
                    crearPost();
                    break;
                case 3:
                    addUsuario();
                    break;
                case 4:
                    ver(0);
                    break;
                case 5:
                    eliminar();
                    break;
                case 6:
                    currentUser = null;
                    System.out.println("Sesion Cerrada");
                    break;
                case 7:
                    System.out.println("Adios...");
            }
            
        }while(op!=7);
        
    }
    
    private static User searchUser(String email){
        for(User u : usuarios){
            if( u.getEmail().equals(email) )
                return u;
        }
        return null;
    }

    private static void login() {
        if( currentUser == null ){
            System.out.println("Email: ");
            String email = lea.next();
            
            currentUser = searchUser(email);
            
            if(currentUser == null)
                System.out.println("Usuario NO existe");
        }
        else{
            System.out.println("Ya estas Logged!");
        }
    }

    private static void crearPost() {
        if( currentUser != null ){
            if( currentUser instanceof Posteable || 
                    currentUser instanceof AdminUser ){
                
                System.out.println("Cuerpo del Post: ");
                String body = lea.next();
                //agrego
                posts.add("Por: "+currentUser.getNombre()+"\n"+body);
                //agrego el post ID al posteable si lo es
                if( currentUser instanceof Posteable ){
                    ((Posteable)currentUser).addPostId(posts.size()-1);
                }
            }
        }
        else
            System.out.println("Por favor LOGIN primero");
    }

    private static void addUsuario() {
        if( currentUser != null ){
            if( currentUser instanceof AdminUser ){
                
                System.out.println("Email: ");
                String email = lea.next();
                
                if(searchUser(email) == null ){
                    System.out.println("Nombre: ");
                    String name = lea.next();
                    System.out.println("Tipo: ");
                    String tipo = lea.next().toUpperCase();
                    
                    if(tipo.equals("USER"))
                        usuarios.add(new User(email, name));
                    else if(tipo.equals("CONTENT"))
                        usuarios.add(new ContentUser(email, name));
                    else if(tipo.equals("ADMIN"))
                        usuarios.add(new AdminUser(email, name));
                    else
                        System.out.println("Tipo NO valido");
                }
                else
                    System.out.println("Email NO es unico");
            }
        }
        else
            System.out.println("Por favor LOGIN primero");
    }

    private static void ver(int pos) {
        if( currentUser != null ){
            if( pos < posts.size() ){
                System.out.println(posts.get(pos));
                System.out.println("-----------------------------------\n");
                ver(pos+1);
            }
        }
        else
            System.out.println("Por favor LOGIN primero");
    }

    private static void eliminar() {
        if( currentUser != null ){
             
            System.out.println("Post id: ");
            int id = lea.nextInt();
                
            if(id>=0 && id < posts.size()){
                
                if( (currentUser instanceof Posteable && ((Posteable)currentUser).accesoAPost(id)) || 
                    currentUser instanceof AdminUser ){
                    
                    posts.remove(id);
                    System.out.println("Borrado con Exito");
                }
                else
                    System.out.println("No tiene Permisos");
               
            }
            else
                System.out.println("Post NO existe");
        }
        else
            System.out.println("Por favor LOGIN primero");
    }
}
