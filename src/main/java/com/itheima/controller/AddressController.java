package com.itheima.controller;

import com.itheima.entities.Address;
import com.itheima.entities.PhoneNumber;
import com.itheima.service.AddressService;
import com.itheima.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        boolean flag = addressService.deleteById(id);
        return new Result(flag,flag == false ? Code.SAVE_OK: Code.SAVE_ERR);
    }
}
