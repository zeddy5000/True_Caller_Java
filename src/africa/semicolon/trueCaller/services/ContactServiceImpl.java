package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;

public class ContactServiceImpl implements ContactService{
    private ContactRepository contactRepository;
    @Override
    public Contact addNewContact(Contact contact) {
        return new Contact();
    }
}
