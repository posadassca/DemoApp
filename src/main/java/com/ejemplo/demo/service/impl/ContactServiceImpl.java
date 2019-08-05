package com.ejemplo.demo.service.impl;

import com.ejemplo.demo.component.ContactConverter;
import com.ejemplo.demo.entity.Contact;
import com.ejemplo.demo.model.ContactModel;
import com.ejemplo.demo.repository.ContactRepository;
import com.ejemplo.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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

}
