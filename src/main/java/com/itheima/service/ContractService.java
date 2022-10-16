package com.itheima.service;

import com.itheima.entities.Contact;
 import  org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContractService extends CrudRepository<Contact,Long> {
    @Query("select c from Contact c where c.lastName =:lastName")
    List<Contact> findContactByName(@Param("lastName") String lastName);


}
