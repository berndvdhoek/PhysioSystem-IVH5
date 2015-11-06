/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.shared.model.domain;

import java.io.Serializable;

/**
 *
 * @author bernd_000
 */
public class Treatment implements Serializable {
    private String BSN;
    private String treatmentCode;

    public Treatment(String BSN, String treatmentCode) {
        this.BSN = BSN;
        this.treatmentCode = treatmentCode;
    }

    public String getBSN() {
        return BSN;
    }

    public void setBSN(String BSN) {
        this.BSN = BSN;
    }

    public String getTreatmentCode() {
        return treatmentCode;
    }

    public void setTreatmentCode(String treatmentCode) {
        this.treatmentCode = treatmentCode;
    }
}
