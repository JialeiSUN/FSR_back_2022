package com.itheima.dao;

import com.itheima.entities.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactDao extends CrudRepository<Contact,Long> {
    @Query("select c from Contact c where c.lastName =:lastName")
    List<Contact> findContactByName(@Param("lastName") String lastName);
}
