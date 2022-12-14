package com.itheima.controller;

import com.itheima.entities.Contact;
import com.itheima.entities.PhoneNumber;
import com.itheima.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phones")
public class PhoneController {
    @Autowired
    private PhoneNumberService phoneNumberService;


    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        boolean flag = phoneNumberService.deleteById(id);
        return new Result(flag,flag == false ? Code.SAVE_OK: Code.SAVE_ERR);
    }
}
