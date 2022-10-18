package com.itheima.controller;

import com.itheima.entities.Address;
import com.itheima.entities.Contact;
import com.itheima.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"localhost:3000"})
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContractService contactService;

    @PostMapping
    public  Result save(@RequestBody Contact contact){
        Contact contact1 = contactService.save(contact);
        return new Result(contact1,contact1!=null ? Code.SAVE_OK: Code.SAVE_ERR);
    }
    @PostMapping("/address/{id}")
    public Result addAddressByContactId(@PathVariable Long id, @RequestBody Address address) {
        Contact contact = contactService.findById(id).get();
        contact.setAddress(address);
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
        Optional<Contact> contact = contactService.findById(id);
        Contact contact1 = contact.get();
        Integer code = contact != null ? Code.GET_OK : Code.GET_ERR;
        String msg = contact1 != null ? "Success" : "Error!";
        return new Result(contact1,code,msg);
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
       List<Contact> contactList = (List<Contact>) contactService.findAll();
        Integer code = contactList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = contactList != null ? "Success" : "Error!";
        return new Result(contactList,code,msg);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        contactService.deleteById(id);
        Optional<Contact> contact = contactService.findById(id);
        boolean flag = contact.isEmpty();
        return new Result(flag,flag == false ? Code.SAVE_OK: Code.SAVE_ERR);
    }


}
