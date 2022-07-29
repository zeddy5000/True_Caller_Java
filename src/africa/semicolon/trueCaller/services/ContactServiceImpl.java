package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.data.repositories.ContactRepositoryImpl;

public class ContactServiceImpl implements ContactService{
    private ContactRepository contactRepository = new ContactRepositoryImpl();
    @Override
    public Contact addNewContact(Contact contact) {
        return  contactRepository.save(contact);
    }
}
