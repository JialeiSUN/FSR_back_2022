package com.itheima.service;

import com.itheima.entities.Address;
import com.itheima.entities.Contact;
import com.itheima.entities.ContactGroup;
import com.itheima.entities.PhoneNumber;
import  org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Transactional
public interface ContactService {
    public List<Contact> findContactByName(String lastName);
    public Contact save(Contact contact);
    public Contact update(Contact contact);
    public boolean deleteById(Long id);
    public  Contact getById(Long id);
    public  List<Contact> getAll();
    public  Contact addPhone(Long id, PhoneNumber phoneNumber);
    public  Contact addAddress(Long id, Address address);
    public  Contact addGroupe(Long id, ContactGroup contactGroup);
    public Contact updatePhones(Long id, Set<PhoneNumber> phones);
    public Contact updateAddress(Long id, Address address);
    public  Contact updateGroups(Long id, Set<ContactGroup> contactGroup);

}
