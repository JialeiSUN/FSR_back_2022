package com.itheima.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "contact")

public class Contact {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private long idContact;


    @OneToOne(mappedBy = "contact",cascade=CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval=true)
    @JoinColumn
    private Address address;

    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "phone_contact")

    private Set<PhoneNumber> phones = new HashSet<PhoneNumber>();
    @ManyToMany(cascade=CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinTable(name="CTC_GRP",
            joinColumns=@JoinColumn(name="idContact"),
            inverseJoinColumns=@JoinColumn(name="idContactGroup"))
    private Set<ContactGroup> contactGroupeList = new HashSet<ContactGroup>();

    public Set<ContactGroup> getContactGroupeList() {
        return contactGroupeList;
    }

    public void setContactGroupeList(Set<ContactGroup> contactGroupeList) {
        this.contactGroupeList = contactGroupeList;
    }

    public Set<PhoneNumber> getPhones() {
        return phones;
    }

    public void setPhones(Set<PhoneNumber> phones) {
        this.phones = phones;
    }

    public Contact(){

    }
    public long getIdContact() {
        return idContact;
    }

    public void setIdContact(long idContact) {
        this.idContact = idContact;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void addContactGroup(ContactGroup contactGroup){
        this.contactGroupeList.add(contactGroup);
    }
}
