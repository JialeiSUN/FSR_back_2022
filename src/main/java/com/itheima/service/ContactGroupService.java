package com.itheima.service;

import com.itheima.entities.ContactGroup;
import org.springframework.data.repository.CrudRepository;

public interface ContactGroupService extends CrudRepository<ContactGroup,Long> {
}
