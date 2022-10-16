package com.itheima.service;

import com.itheima.entities.Address;
import com.itheima.entities.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressService extends CrudRepository<Address,Long> {
}
