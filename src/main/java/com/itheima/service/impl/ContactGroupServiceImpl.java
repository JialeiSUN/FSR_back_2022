package com.itheima.service.impl;

import com.itheima.dao.ContactDao;
import com.itheima.dao.ContactGroupDao;
import com.itheima.entities.Contact;
import com.itheima.entities.ContactGroup;
import com.itheima.service.ContactGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ContactGroupServiceImpl implements ContactGroupService {
    @Autowired
    private ContactGroupDao contactGroupDao;
    @Autowired
    private ContactDao contactDao;

    @Override
    public ContactGroup save(ContactGroup contactGroup) {

        return contactGroupDao.save(contactGroup);
    }

    @Override
    public ContactGroup update(ContactGroup contactGroup) {
        return contactGroupDao.save(contactGroup);
    }

    @Override
    public boolean deleteById(Long id) {

        ContactGroup contactGroup = contactGroupDao.findById(id).get();
         Set <Contact>  contactSet = contactGroup.getContactList();

        contactSet.forEach((e)->{
            e.getContactGroupeList().remove(contactGroup);
            contactDao.save(e);
        });
        contactGroupDao.deleteById(id);
        Optional<ContactGroup> contactGroup1 = contactGroupDao.findById(id);
        boolean flag = contactGroup1.isEmpty();
        return flag;
    }

    @Override
    public ContactGroup getById(Long id) {
        return contactGroupDao.findById(id).get();
    }

    @Override
    public List<ContactGroup> getAll() {
        return (List<ContactGroup>) contactGroupDao.findAll();
    }
}
