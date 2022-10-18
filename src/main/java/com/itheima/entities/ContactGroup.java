package com.itheima.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "contactgroupe")
public class ContactGroup {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private long idContactGroup;
    @Column
    private String groupName;
    @ManyToMany(mappedBy = "contactGroupeList")
    @JsonIgnore
    private Set<Contact> contactList = new HashSet<Contact>();
    public ContactGroup(){

    }

    public long getIdContactGroup() {
        return idContactGroup;
    }

    public void setIdContactGroup(long idContactGroup) {
        this.idContactGroup = idContactGroup;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Set<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(Set<Contact> contactList) {
        this.contactList = contactList;
    }
}
