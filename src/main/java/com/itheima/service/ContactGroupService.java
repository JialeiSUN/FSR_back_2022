package com.itheima.service;

import com.itheima.entities.Contact;
import com.itheima.entities.ContactGroup;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactGroupService{
    public ContactGroup save(ContactGroup contactGroup);
    public ContactGroup update(ContactGroup contactGroup);
    public boolean deleteById(Long id);
    public  ContactGroup getById(Long id);
    public  List<ContactGroup> getAll();
}
