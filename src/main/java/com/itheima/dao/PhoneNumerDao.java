package com.itheima.dao;

import com.itheima.entities.PhoneNumber;
import org.springframework.data.repository.CrudRepository;

public interface PhoneNumerDao extends CrudRepository<PhoneNumber,Long> {

}
