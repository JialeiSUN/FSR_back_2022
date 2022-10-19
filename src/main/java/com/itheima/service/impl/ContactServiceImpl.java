package com.itheima.service.impl;

import com.itheima.dao.ContactDao;
import com.itheima.entities.Address;
import com.itheima.entities.Contact;
import com.itheima.entities.ContactGroup;
import com.itheima.entities.PhoneNumber;
import com.itheima.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactDao contactDao;

    @Override
    public List<Contact> findContactByName(String lastName) {
        return contactDao.findContactByName(lastName);
    }

    @Override
    public Contact save(Contact contact) {
        return contactDao.save(contact);
    }

    @Override
    public Contact update(Contact contact) {
        return contactDao.save(contact);
    }

    @Override
    public boolean deleteById(Long id) {
        contactDao.deleteById(id);
        Optional<Contact> contact = contactDao.findById(id);
        boolean flag = contact.isEmpty();
        return flag;
    }

    @Override
    public Contact getById(Long id) {
        return contactDao.findById(id).get();
    }

    @Override
    public List<Contact> getAll() {
        return (List<Contact>) contactDao.findAll();
    }

    @Override
    public Contact addPhone(Long id, PhoneNumber phoneNumber) {
        Contact contact = contactDao.findById(id).get();
        phoneNumber.setPhone_contact(contact);
        Set<PhoneNumber> phones =  contact.getPhones();
        phones.add(phoneNumber);
        contact.setPhones(phones);
        return  contactDao.save(contact);
    }

    @Override
    public Contact addAddress(Long id, Address address) {
        Contact contact = contactDao.findById(id).get();
        address.setContact(contact);
        contact.setAddress(address);
        return  contactDao.save(contact);
    }

    @Override
    public Contact addGroupe(Long id, ContactGroup contactGroup) {
        Contact contact = contactDao.findById(id).get();

        Set<Contact> contactList = contactGroup.getContactList();
        contactList.add(contact);
        contactGroup.setContactList(contactList);

        Set<ContactGroup> groupList = contact.getContactGroupeList();
        groupList.add(contactGroup);
        contact.setContactGroupeList(groupList);
        return  contactDao.save(contact);
    }

    @Override
    public Contact updatePhones(Long id, Set<PhoneNumber> phones) {
        Contact contact = contactDao.findById(id).get();
        contact.setPhones(phones);
        phones.forEach((e) -> {
            e.setPhone_contact(contact);
        });
        return contactDao.save(contact);
    }

    @Override
    public Contact updateAddress(Long id, Address address) {
        Contact contact = contactDao.findById(id).get();
        contact.setAddress(address);
        address.setContact(contact);
        return contactDao.save(contact);
    }

    @Override
    public Contact updateGroups(Long id, Set<ContactGroup> contactGroup) {
        Contact contact = contactDao.findById(id).get();
        contact.setContactGroupeList(contactGroup);
        contactGroup.forEach((e) -> {
           Set<Contact> contactSet = e.getContactList();
           contactSet.add(contact);
           e.setContactList(contactSet);
        });
        return contactDao.save(contact);
    }


}
