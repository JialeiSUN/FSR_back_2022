package com.itheima.service.impl;

import com.itheima.dao.ContactDao;
import com.itheima.entities.Contact;
import com.itheima.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
}
