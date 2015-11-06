/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.view.ui;

import edu.avans.ivh5.client.control.CompanyController;
import edu.avans.ivh5.shared.model.domain.CompanyInfo;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author bernd_000
 */
public class CompanyInfoPanel extends JPanel {
    
    private JButton saveButton;
    private JTextField nameField, adressField, postcodeField, placeField, phoneField, mailField, KVKField, IBANField, BICField, bankField;
    private CompanyController controller;
    private MainTabbedPaneScreen parentScreen;
    
    public CompanyInfoPanel(MainTabbedPaneScreen parentScreen, CompanyController controller) {
        this.parentScreen = parentScreen;
        this.controller = controller;
        controller.setUIRef(this);
        setLayout(new BorderLayout());
        add(createCenterPanel(), BorderLayout.CENTER);
        setCompanyValues();
    }
    
    public JPanel createCenterPanel() {
        JPanel panel = new JPanel();
        
        panel.setLayout(new GridLayout(11,4,5,5));
        panel.setBorder(new EmptyBorder(300,300,300,300));
        // row 1
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        
        saveButton = new JButton("Opslaan");
        saveButton.setActionCommand("saveCompanyInfo");
        saveButton.addActionListener(controller);
        panel.add(saveButton);
        // end of row 1
        
        // row 2
        panel.add(new JLabel("Naam praktijk:"));
        
        nameField = new JTextField();
        panel.add(nameField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        // end of row 2
        
        // row 3
        panel.add(new JLabel("Straatnaam + huisnummer:"));
        
        adressField = new JTextField();
        panel.add(adressField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        // end of row 3
        
        // row 4
        panel.add(new JLabel("Postcode:"));
        
        postcodeField = new JTextField();
        panel.add(postcodeField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        // end of row 4
        
        // row 5
        panel.add(new JLabel("Plaats:"));
        
        placeField = new JTextField();
        panel.add(placeField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        // end of row 5
        
        // row 6
        panel.add(new JLabel("Telefoonnummer:"));
        
        phoneField = new JTextField();
        panel.add(phoneField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        // end of row 6
        
        // row 7
        panel.add(new JLabel("Email"));
        
        mailField = new JTextField();
        panel.add(mailField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        // end of row 7
        
        // row 8
        panel.add(new JLabel("KVK nummer:"));
        
        KVKField = new JTextField();
        panel.add(KVKField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        // end of row 8
        
        // row 9
        panel.add(new JLabel("IBAN:"));
        
        IBANField = new JTextField();
        panel.add(IBANField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        // end of row 9
        
        // row 10
        panel.add(new JLabel("BIC:"));
        
        BICField = new JTextField();
        panel.add(BICField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        // end of row 10
        
        // row 11
        panel.add(new JLabel("Naam bank:"));
        
        bankField = new JTextField();
        panel.add(bankField);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        // end of row 11
        return panel;
    }
    
    private void setCompanyValues() {
        System.out.println("Setting company info");
        //CompanyInfo info = controller.getCompanyInfo();
        //System.out.println("Company name: " + info.getName());
    }
    
}
