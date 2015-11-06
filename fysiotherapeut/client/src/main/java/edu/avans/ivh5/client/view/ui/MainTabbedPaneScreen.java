/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.client.view.ui;

import edu.avans.ivh5.api.PhysioManagerClientIF;
import edu.avans.ivh5.client.control.CompanyController;
import edu.avans.ivh5.client.control.ReportingController;
import edu.avans.ivh5.client.control.TherapistController;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author bernd_000
 */
public class MainTabbedPaneScreen extends JFrame {
    
    private final PhysioManagerClientIF manager;
    
    public MainTabbedPaneScreen(PhysioManagerClientIF manager) {
        this.manager = manager;
        setTitle("Fysiopraktijk");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        createTabs();
        
        setVisible(true);
    }
    
    private void createTabs() {
        System.out.println("Initializing MainTabbedPaneScreen");
        JTabbedPane panes = new JTabbedPane();
        
        System.out.println("Initializing SchedulePanel");
        JPanel SchedulePanel = new JPanel();
        System.out.println("Successfully initialized SchedulePanel");
        System.out.println("Initializing TreatmentsPanel");
        JPanel TreatmentsPanel = new TreatmentPanel(this);
        System.out.println("Successfully initialized TreatmentsPanel");
        System.out.println("Initializing OverviewPanel");
        JPanel OverviewPanel = new OverviewPanel(this, new ReportingController(manager));
        System.out.println("Successfully initialized OverviewPanel");
        System.out.println("Initializing EmployeePanel");
        JPanel EmployeePanel = new EmployeePanel(this, new TherapistController(manager));
        System.out.println("Successfully initialized EmployeePanel");
        System.out.println("Initializing CompanyInfoPanel");
        JPanel CompanyInfoPanel = new CompanyInfoPanel(this, new CompanyController(manager));
        System.out.println("Successfully initialized CompanyInfoPanel");
        
        panes.add("Agenda", SchedulePanel);
        panes.add("Behandelingen", TreatmentsPanel);
        panes.add("Overzichten", OverviewPanel);
        panes.add("Fysiotherapeuten", EmployeePanel);
        panes.add("Praktijkgegevens", CompanyInfoPanel);
        
        add(panes);
        System.out.println("Successfully initialized MainTabbedPaneScreen");
    }
}
