/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.server.model.dao.xml.dom;

import edu.avans.ivh5.server.model.dao.api.CompanyDAOIF;
import edu.avans.ivh5.shared.model.domain.CompanyInfo;
import edu.avans.ivh5.shared.util.Settings;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author bernd_000
 */
public class XMLDOMCompanyDAO implements CompanyDAOIF {
    private XmlDOMDocument domDocument = null;
    private Document document = null;
    private final String XMLDocumentName, XSDDocumentName;

    public XMLDOMCompanyDAO() {
        XMLDocumentName = Settings.props.getProperty(Settings.propXmlCompanyInfoFile);
        XSDDocumentName = Settings.props.getProperty(Settings.propXmlCompanyInfoXSD);
        this.domDocument = new XmlDOMDocument(
                Settings.props.getProperty(Settings.propXmlFileLocation) + XMLDocumentName,
                Settings.props.getProperty(Settings.propXmlEmployeesXSD) + XSDDocumentName);
        this.document = domDocument.getDocument();
    }

    @Override
    public CompanyInfo getCompanyInfo() {
        System.out.println("XMLDOMCompanyDAO is getting the company info");
        if (document != null) {
            NodeList list = document.getElementsByTagName("company");

            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                if (node instanceof Element) {
                    Element child = (Element) node;
                    System.out.println(child.getElementsByTagName("name").item(0).getTextContent());
                }
            }
        }
        return null;
    }

    @Override
    public boolean saveCompanyInfo() {
        return false;
    }
    
    
}
