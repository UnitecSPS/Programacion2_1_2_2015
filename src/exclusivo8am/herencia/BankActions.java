/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exclusivo8am.herencia;

/**
 *
 * @author Docente 17082011
 */
public interface BankActions {
    void createAccount(int num, String n, double s, String t);
    CuentaBancaria searchAccount(int num);
    void deposit(int num, double m);
    void print();
}
