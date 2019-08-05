package com.ejemplo.demo.service.impl;

import com.ejemplo.demo.component.ContactConverter;
import com.ejemplo.demo.entity.Contact;
import com.ejemplo.demo.model.ContactModel;
import com.ejemplo.demo.repository.ContactRepository;
import com.ejemplo.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {

    @Autowired
    @Qualifier("contactRepository")
    private ContactRepository contactRepository;

    @Autowired
    @Qualifier("contactConverter")
    private ContactConverter contactConverter;

    @Override
    public ContactModel addContact(ContactModel contactModel) {
        Contact contact = contactRepository.save(contactConverter.convertToContactModelToContact(contactModel));
        return contactConverter.convertToContactToContactModel(contact);
    }

    @Override
    public List<ContactModel> listAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        List<ContactModel> contactsModel = new ArrayList<>();

        for(Contact contact : contacts){
            contactsModel.add(contactConverter.convertToContactToContactModel(contact));
        }
        return contactsModel;
    }

    @Override
    public Contact findContactById(int id) {
        return contactRepository.findById(id);
    }

    @Override
    public ContactModel findContactByIdModel(int id) {
        return contactConverter.convertToContactToContactModel(findContactById(id));
    }

    @Override
    public void removeContact(int id) {
        Contact contact = contactRepository.findById(id);
        if(contact != null){
            contactRepository.delete(contact);
        }
    }

}
