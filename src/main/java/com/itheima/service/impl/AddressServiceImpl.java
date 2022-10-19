package com.itheima.service.impl;

import com.itheima.dao.AddressDao;
import com.itheima.entities.Address;
import com.itheima.entities.Contact;
import com.itheima.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;

    @Override
    public Address save(Address address) {
        return addressDao.save(address);
    }

    @Override
    public Address update(Address address) {
        return addressDao.save(address);
    }

    @Override
    public boolean deleteById(Long id) {
        addressDao.deleteById(id);
        Optional<Address> address = addressDao.findById(id);
        boolean flag = address.isEmpty();
        return flag;
    }

    @Override
    public Address getById(Long id) {
        return addressDao.findById(id).get();
    }

    @Override
    public List<Address> getAll() {
        return (List<Address>) addressDao.findAll();
    }
}
