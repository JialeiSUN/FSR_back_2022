package com.itheima.controller;

import com.itheima.entities.Address;
import com.itheima.entities.Contact;
import com.itheima.entities.PhoneNumber;
import com.itheima.service.AddressService;
import com.itheima.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private AddressService addressService;

    @PostMapping
    public  Result save(@RequestBody Contact contact){
        Contact contact1 = contactService.update(contact);
        return new Result(contact1,contact1!=null ? Code.SAVE_OK: Code.SAVE_ERR);
    }
    @PostMapping("/address/{id}")
    public Result addAddressByContactId(@PathVariable Long id, @RequestBody Address address) {
        Contact contact = contactService.getById(id);
        contact.setAddress(address);
        Contact contact1 = contactService.save(contact);
        Integer code = contact1 != null ? Code.GET_OK : Code.GET_ERR;
        String msg = contact1 != null ? "Success" : "Error!";
        return new Result(contact1,code,msg);
    }
    @PutMapping("/address/{id}")
    public Result updateAddressByContactId(@PathVariable Long id, @RequestBody Address address) {
        Contact contact = contactService.getById(id);
        contact.setAddress(address);
        address.setContact(contact);
        Contact contact1 = contactService.save(contact);
        Integer code = contact1 != null ? Code.GET_OK : Code.GET_ERR;
        String msg = contact1 != null ? "Success" : "Error!";
        return new Result(contact1,code,msg);
    }
    @PutMapping("/phones/{id}")
    public Result updatePhonesByContactId(@PathVariable Long id, @RequestBody Set<PhoneNumber> phones) {
        Contact contact = contactService.getById(id);
        contact.setPhones(phones);
        phones.forEach((e) -> {
           e.setPhone_contact(contact);
        });
        Contact contact1 = contactService.save(contact);
        Integer code = contact1 != null ? Code.GET_OK : Code.GET_ERR;
        String msg = contact1 != null ? "Success" : "Error!";
        return new Result(contact1,code,msg);
    }
    @PutMapping
    public  Result update(@RequestBody Contact contact){
        Contact contact1 = contactService.save(contact);
        return new Result(contact1,contact1!=null ? Code.UPDATE_OK: Code.UPDATE_ERR);
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Long id) {
        Contact contact = contactService.getById(id);
        Integer code = contact != null ? Code.GET_OK : Code.GET_ERR;
        String msg = contact != null ? "Success" : "Error!";
        return new Result(contact,code,msg);
    }
    @GetMapping("/byname/{name}")
    public Result getByName(@PathVariable String name) {
        List<Contact> contactList = (List<Contact>) contactService.findContactByName(name);
        Integer code = contactList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = contactList != null ? "Success" : "Error!";
        return new Result(contactList,code,msg);
    }
    @GetMapping()
    public Result getAll() {
       List<Contact> contactList = contactService.getAll();
        Integer code = contactList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = contactList != null ? "Success" : "Error!";
        return new Result(contactList,code,msg);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        boolean flag = contactService.deleteById(id);
        return new Result(flag,flag == false ? Code.SAVE_OK: Code.SAVE_ERR);
    }


}
