/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.IDao;
import entities.Machine;
import entities.Salle;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.MachineService;
import service.SalleService;
import util.HibernateUtil;

/**
 *
 * @author Lachgar
 */
public class Test {

    public static void main(String[] args) {
        try {
            IDao<Machine> machineDao = new MachineService();

            for (Machine m : machineDao.findAll()) {
                System.out.println(m);
            }

            IDao<Salle> salleDao = new SalleService();
            
            salleDao.create(new Salle("Salle1"));
            salleDao.create(new Salle("Salle2"));
            salleDao.create(new Salle("Salle3"));

            for (Salle s : salleDao.findAll()) {
                System.out.println(s);
            }

        } catch (RemoteException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
