package com.itheima.service.impl;

import com.itheima.dao.PhoneNumerDao;
import com.itheima.entities.PhoneNumber;
import com.itheima.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PhoneNumberServiceImpl implements PhoneNumberService {
    @Autowired
    private PhoneNumerDao phoneNumerDao;
    @Override
    public PhoneNumber save(PhoneNumber phoneNumber) {
        return phoneNumerDao.save(phoneNumber);
    }

    @Override
    public PhoneNumber update(PhoneNumber phoneNumber) {
        return phoneNumerDao.save(phoneNumber);
    }

    @Override
    public boolean deleteById(Long id) {

        phoneNumerDao.deleteById(id);
        Optional<PhoneNumber> contact = phoneNumerDao.findById(id);
        boolean flag = contact.isEmpty();
        return flag;
    }

    @Override
    public PhoneNumber getById(Long id) {
        return phoneNumerDao.findById(id).get();
    }

    @Override
    public List<PhoneNumber> getAll() {
        return (List<PhoneNumber>) phoneNumerDao.findAll();
    }
}
