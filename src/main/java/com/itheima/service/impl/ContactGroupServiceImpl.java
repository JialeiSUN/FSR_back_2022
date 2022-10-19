package com.itheima.service.impl;

import com.itheima.dao.ContactDao;
import com.itheima.dao.ContactGroupDao;
import com.itheima.entities.ContactGroup;
import com.itheima.service.ContactGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ContactGroupServiceImpl implements ContactGroupService {
    @Autowired
    private ContactGroupDao contactGroupDao;

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
        contactGroupDao.deleteById(id);
        Optional<ContactGroup> contactGroup = contactGroupDao.findById(id);
        boolean flag = contactGroup.isEmpty();
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
