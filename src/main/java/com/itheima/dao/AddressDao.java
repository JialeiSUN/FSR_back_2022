package com.itheima.dao;

import com.itheima.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressDao extends CrudRepository<Address,Long> {
}
