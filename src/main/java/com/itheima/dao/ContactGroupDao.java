package com.itheima.dao;

import com.itheima.entities.ContactGroup;
import org.springframework.data.repository.CrudRepository;

public interface ContactGroupDao extends CrudRepository<ContactGroup,Long> {
}
