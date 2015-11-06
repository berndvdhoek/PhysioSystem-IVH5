/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.control;

import edu.avans.ivh5.api.PhysioManagerClientIF;
import edu.avans.ivh5.client.view.ui.CompanyInfoPanel;
import edu.avans.ivh5.shared.model.domain.CompanyInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

/**
 *
 * @author bernd_000
 */
public class CompanyController implements ActionListener {

    private final PhysioManagerClientIF manager;
    private CompanyInfoPanel parentScreen;

    public CompanyController(PhysioManagerClientIF manager) {
        this.manager = manager;
    }

    public void setUIRef(CompanyInfoPanel panel) {
        this.parentScreen = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("saveCompanyInfo")) {

        }
    }

    public CompanyInfo getCompanyInfo() {
        try {
            System.out.println("Controller is calling the manager");
            return manager.getCompanyInfo();
        } catch (RemoteException ex) {
            System.out.println("RemoteException while gettig company info");
        }
        return null;
    }

}
