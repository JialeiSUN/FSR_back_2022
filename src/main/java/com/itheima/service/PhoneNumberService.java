package com.itheima.service;

import com.itheima.entities.PhoneNumber;

import java.util.List;

public interface PhoneNumberService {
    public PhoneNumber save(PhoneNumber phoneNumber);
    public PhoneNumber update(PhoneNumber phoneNumber);
    public boolean deleteById(Long id);
    public  PhoneNumber getById(Long id);
    public List<PhoneNumber> getAll();
}
