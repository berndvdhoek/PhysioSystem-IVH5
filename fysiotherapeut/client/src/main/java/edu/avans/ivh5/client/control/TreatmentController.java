/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.control;

import edu.avans.ivh5.api.PhysioManagerClientIF;
import edu.avans.ivh5.client.view.ui.AddTreatmentScreen;
import edu.avans.ivh5.shared.model.domain.Employee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author bernd_000
 */
public class TreatmentController implements ActionListener{

    private PhysioManagerClientIF manager;
    private AddTreatmentScreen parentScreen;

    public TreatmentController(PhysioManagerClientIF manager) {
        this.manager = manager;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    public void setUIRef(AddTreatmentScreen parentScreen) {
        this.parentScreen = parentScreen;
    }
    
    public ArrayList<Employee> loadTherapists() throws RemoteException{
        ArrayList<Employee> therapists = manager.getEmployees();
        therapists.stream().forEach(therapist -> System.out.println(therapist.getLastname()));
        return therapists;
    }
    
    
    
}
