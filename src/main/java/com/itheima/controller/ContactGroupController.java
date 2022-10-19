package com.itheima.controller;

import com.itheima.entities.Contact;
import com.itheima.entities.ContactGroup;
import com.itheima.service.ContactGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groupes")
public class ContactGroupController {
    @Autowired
    private ContactGroupService contactGroupService;
    @GetMapping()
    public Result getAll() {
        List<ContactGroup> contactGroupList = contactGroupService.getAll();
        Integer code = contactGroupList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = contactGroupList != null ? "Success" : "Error!";
        return new Result(contactGroupList,code,msg);
    }
    @PostMapping
    public  Result save(@RequestBody ContactGroup contactGroup){
        ContactGroup contactGroup1 = contactGroupService.save(contactGroup);
        return new Result(contactGroup1,contactGroup1!=null ? Code.SAVE_OK: Code.SAVE_ERR);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        boolean flag = contactGroupService.deleteById(id);
        return new Result(flag,flag == false ? Code.SAVE_OK: Code.SAVE_ERR);
    }

}
