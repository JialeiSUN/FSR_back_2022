package com.itheima.service;

import com.itheima.entities.PhoneNumber;
import org.springframework.data.repository.CrudRepository;

public interface PhoneNumerService extends CrudRepository<PhoneNumber,Long> {
}
