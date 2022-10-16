package com.itheima.controller;

import com.itheima.entities.Address;
import com.itheima.entities.Contact;
import com.itheima.service.AddressService;
import com.itheima.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;
    @Autowired
    private ContractService contactService;
    @GetMapping("/{id}")
    public Result getById(@PathVariable Long id) {
        Optional<Address> address = addressService.findById(id);
        Address address1 = address.get();
        Integer code = address1 != null ? Code.GET_OK : Code.GET_ERR;
        String msg = address1 != null ? "Success" : "Error!";
        return new Result(address1,code,msg);
    }
    @GetMapping("/contact/{id}")
    public Result getByContactId(@PathVariable Long id) {
        Contact contact = contactService.findById(id).get();
        Address address1 = contact.getAddress();
        Integer code = address1 != null ? Code.GET_OK : Code.GET_ERR;
        String msg = address1 != null ? "Success" : "Error!";
        return new Result(address1,code,msg);
    }

}
