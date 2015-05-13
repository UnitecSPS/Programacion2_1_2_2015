/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Docente 17082011
 */
public interface INetwork {
    void addDevice(String name);
    void printNetwork();
    boolean connectDeviceWith(String d1name, String d2name);
    boolean existDevice(String name);
}
