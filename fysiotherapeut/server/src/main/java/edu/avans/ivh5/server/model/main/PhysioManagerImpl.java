/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.model.main;

import edu.avans.ivh5.api.PhysioManagerClientIF;
import edu.avans.ivh5.server.model.dao.DAOFactory;
import edu.avans.ivh5.server.model.dao.api.CompanyDAOIF;
import edu.avans.ivh5.server.model.dao.api.EmployeeDAOIF;
import edu.avans.ivh5.server.model.dao.api.UserDAOIF;
import edu.avans.ivh5.shared.model.domain.ClientDTO;
import edu.avans.ivh5.shared.model.domain.CompanyInfo;
import edu.avans.ivh5.shared.model.domain.Employee;
import edu.avans.ivh5.shared.model.domain.Session;
import edu.avans.ivh5.shared.model.domain.Treatment;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author bernd_000
 */
public class PhysioManagerImpl implements PhysioManagerClientIF /*PhysioServerInterface*/ {

    private final DAOFactory daoFactory;
    private final PasswordManager passwordManager;
    private final String service;

    public PhysioManagerImpl(String service) {
        daoFactory = DAOFactory.getDAOFactory("edu.avans.ivh5.server.model.dao.xml.dom.XmlDOMDAOFactory");
        passwordManager = new PasswordManager();
        this.service = service;
    }
    
    @Override
    public boolean checkPassword(String username, char[] password) throws RemoteException {
        System.out.println("PhysioManagerImpl is checking password");
        UserDAOIF userDAO = daoFactory.getUserDAO();
        if (userDAO.checkUserExistance(username)) {
            String hashedPassword = passwordManager.hashPassword(
                    passwordManager.saltPassword(password, userDAO.getSalt(username))
                    .getBytes()
            );

            boolean passwordIsCorrect = userDAO.checkPassword(username, hashedPassword);
            System.out.println("PhysioManagerImpl returns: " + passwordIsCorrect + "\n");
            return passwordIsCorrect;
        }
        System.out.println("PhysioManagerImpl returns: false\n");
        return false;
    }

    @Override
    public boolean saveEmployee(Employee employee) throws RemoteException {
        System.out.println("Create employeeDao with daofactory");
        EmployeeDAOIF dao = daoFactory.getEmployeeDAO();
        System.out.println("dao saving employee");
        return dao.saveEmployee(employee);
    }

    @Override
    public void alterEmployee(Employee employee) throws RemoteException {
        System.out.println("alter employee in manager");
        EmployeeDAOIF dao = daoFactory.getEmployeeDAO();
        System.out.println("dao alter employee");
        dao.alterEmployee(employee);
    }

    @Override
    public boolean removeEmployee(String employeeID) throws RemoteException {
        System.out.println("delete employee in manager");
        EmployeeDAOIF dao = daoFactory.getEmployeeDAO();
        System.out.println("dao delete employee");
        return dao.deleteEmployee(employeeID);
    }

    @Override
    public ArrayList<Employee> getEmployees() throws RemoteException {
        EmployeeDAOIF dao = daoFactory.getEmployeeDAO();
        return dao.getEmployees();
    }

    @Override
    public int getMaxID() throws RemoteException {
        EmployeeDAOIF dao = daoFactory.getEmployeeDAO();
        return dao.getMaxID();
    }

    @Override
    public Employee getTherapist(String name) throws RemoteException {
        EmployeeDAOIF employeeDAO = daoFactory.getEmployeeDAO();
        return employeeDAO.getEmployee(name);
    }

    @Override
    public boolean saveTreatment(Treatment treatment) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterTreatment(Treatment treatment) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteTreatment(Treatment treatment) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveSession(Session session) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterSession(Session session) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteSession(Session session) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClientDTO getClient() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Treatment> getTreatmentsByTherapistID(int therapistID) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getBSNBySession(int sessionID) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee getTherapistBySession(int sessionID) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Treatment getTreatmentBySession(int sessionID) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Treatment getTreatmentByID(int treatmentID) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CompanyInfo getCompanyInfo() throws RemoteException {
        System.out.println("Manager is calling the dao");
        CompanyDAOIF dao = daoFactory.getCompanyDAO();
        return dao.getCompanyInfo();
    }
    /*
    @Override
    public ArrayList<SharedTreatment> getAllFinishedTreatments() throws RemoteException {
        ArrayList<SharedTreatment> treatments = new ArrayList<>();
        treatments.add(new SharedTreatment("209000454", "001behandelcode001", 21));
        treatments.add(new SharedTreatment("500005243", "002behandelcode002", 11));
        treatments.add(new SharedTreatment("209000454", "003behandelcode003", 14));
        return treatments;
    }
    */
}
