package com.ejemplo.demo.component;

import com.ejemplo.demo.entity.Contact;
import com.ejemplo.demo.model.ContactModel;
import org.springframework.stereotype.Component;

@Component("contactConverter")
public class ContactConverter {

    public Contact convertToContactModelToContact(ContactModel contactModel){
        Contact contact = new Contact();
        contact.setId(contactModel.getId());
        contact.setCity(contactModel.getCity());
        contact.setFirstName(contactModel.getFirstName());
        contact.setLastName(contactModel.getLastName());
        contact.setTelephone(contactModel.getTelephone());
        return contact;
    }

    public ContactModel convertToContactToContactModel(Contact contact){
        ContactModel contactModel = new ContactModel();
        contactModel.setId(contact.getId());
        contactModel.setCity(contact.getCity());
        contactModel.setFirstName(contact.getFirstName());
        contactModel.setLastName(contact.getLastName());
        contactModel.setTelephone(contact.getTelephone());
        return contactModel;
    }

}
