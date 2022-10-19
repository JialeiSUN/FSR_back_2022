package com.itheima.service;

import com.itheima.config.SpringConfig;
import com.itheima.entities.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;


@ContextConfiguration(classes = SpringConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ContactServiceTest {
    @Autowired
    private ContactService contactService;
    @Autowired
    private ContactGroupService contactGroupService;

    @Autowired
    private  PhoneNumberService phoneNumberService;
    @Test
    public void testC_contact_address(){
        //contact

        Contact testContact = new Contact();
        testContact.setEmail("test4@gmail.com");
        testContact.setFirstName("test4");
        testContact.setLastName("test4");

        //PhoneNumber1

        PhoneNumber testPhone = new PhoneNumber();
        testPhone.setPhoneNumber("0612345778");
        testPhone.setPhoneType("vivo");
        testPhone.setPhone_contact(testContact);
        //PhoneNumber2
        PhoneNumber testPhone1 = new PhoneNumber();
        testPhone1.setPhoneNumber("0612345678");
        testPhone1.setPhoneType("oppo");
        testPhone1.setPhone_contact(testContact);

        //ajouter tous les phones dans contact
        Set<PhoneNumber> phones = new HashSet<PhoneNumber>();
        phones.add(testPhone);
        phones.add(testPhone1);
        testContact.setPhones(phones);

        //address

        Address testAddress = new Address();
        testAddress.setCity("nanterre");
        testAddress.setCountry("FR");
        testAddress.setZip("92000");
        testAddress.setStreet("test");
        testAddress.setContact(testContact);


        // ajouter l'adresse dans contact
        testContact.setAddress(testAddress);
        contactService.save(testContact);
    }
    @Test
    public void testInser(){
        Contact testContact2 = new Contact();
        testContact2.setEmail("test@gmail.com");
        testContact2.setLastName("test2");
        testContact2.setFirstName("test2");
        contactService.save(testContact2);
    }
    @Test
    public void test_Group_contact(){
        Contact testContact1 = contactService.getById(2L);
        Contact testContact3 = contactService.getById(1L);

        Set<ContactGroup> contactGroupList =new HashSet<ContactGroup>();
        ContactGroup contactGroup = new ContactGroup();
        contactGroup.setGroupName("testgroupe2");
        contactGroupList.add(contactGroup);

        testContact1.setContactGroupeList(contactGroupList);

        testContact3.setContactGroupeList(contactGroupList);

        Set<Contact> contactList =new HashSet<Contact>();
        contactList.add(testContact1);
        contactList.add(testContact3);
        contactGroup.setContactList(contactList);
        contactGroupService.save(contactGroup);
        contactService.save(testContact1);
        contactService.save(testContact3);
    }
    @Test
    public void testAddNewGroupe(){
        Contact testContact3 = contactService.getById(11L);
        ContactGroup testContactGroupe1 = contactGroupService.getById(3L);
        ContactGroup testGroupe1 = contactGroupService.getById(1L);

        Set<ContactGroup> contactGroupList =new HashSet<ContactGroup>();
        Set<Contact> contactSet = new HashSet<Contact>();

        contactSet.add(testContact3);
        contactGroupList.add(testContactGroupe1);
        contactGroupList.add(testGroupe1);

        contactGroupList.forEach((e) -> {
            e.setContactList(contactSet);
        });
        contactSet.forEach((e)->{
            e.setContactGroupeList(contactGroupList);
        });
        contactService.save(testContact3);

    }
    @Test
    public void testDeletePhoneNumber(){
        phoneNumberService.deleteById(3L);
    }
}
