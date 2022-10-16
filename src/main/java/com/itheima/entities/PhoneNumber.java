package com.itheima.entities;

import javax.persistence.*;
import javax.persistence.Table;

@Entity

@Table(name = "phonenumber")
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private long phone_id;
    @Column
    private String phoneType;
    @Column
    private String phoneNumber;

    public Contact getPhone_contact() {
        return phone_contact;
    }

    public PhoneNumber() {
    }

    public void setPhone_contact(Contact phone_contact) {
        this.phone_contact = phone_contact;
    }

    @ManyToOne
    @JoinColumn(name="idContact",nullable = true)
    private Contact phone_contact;
    public long getPhone_id() {
        return phone_id;
    }

    public void setPhone_id(long phone_id) {
        this.phone_id = phone_id;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



}
