package com.itheima.service;

import com.itheima.entities.Contact;
 import  org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface ContactService {
    public List<Contact> findContactByName(String lastName);
    public Contact save(Contact contact);
    public Contact update(Contact contact);
    public boolean deleteById(Long id);
    public  Contact getById(Long id);
    public  List<Contact> getAll();

}
