package com.ejemplo.demo.service;


import com.ejemplo.demo.entity.Contact;
import com.ejemplo.demo.model.ContactModel;

import java.util.List;

public interface ContactService {

    public abstract ContactModel addContact(ContactModel contactModel);
    public abstract List<ContactModel> listAllContacts();
    public abstract Contact findContactById(int id);
    public abstract ContactModel findContactByIdModel(int id);
    public abstract void removeContact(int id);
}
