package com.itheima.service;

import com.itheima.entities.Address;
import com.itheima.entities.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressService {
    public Address save(Address address);
    public Address update(Address address);
    public boolean deleteById(Long id);
    public  Address getById(Long id);
    public  List<Address> getAll();
}
