/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.avans.ivh5.shared.model.domain;

/**
 *
 * @author bernd_000
 */
public class CompanyInfo {
    private String name, street, zipcode, place, phoneNumber, email, KVKNummer, IBAN, BIC, bank;

    public CompanyInfo(String name, String street, String zipcode, String place, String phoneNumber, String email, String KVKNummer, String IBAN, String BIC, String bank) {
        this.name = name;
        this.street = street;
        this.zipcode = zipcode;
        this.place = place;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.KVKNummer = KVKNummer;
        this.IBAN = IBAN;
        this.BIC = BIC;
        this.bank = bank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKVKNummer() {
        return KVKNummer;
    }

    public void setKVKNummer(String KVKNummer) {
        this.KVKNummer = KVKNummer;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getBIC() {
        return BIC;
    }

    public void setBIC(String BIC) {
        this.BIC = BIC;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
}
