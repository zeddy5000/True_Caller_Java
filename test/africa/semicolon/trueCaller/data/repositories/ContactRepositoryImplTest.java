package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactRepositoryImplTest {
    @Test
    public void saveContactCountIncreasesTest(){
        ContactRepository contactRepository = new ContactRepositoryImpl();
        Contact contact = new Contact();
        contact.setPhoneNumber("07051875928");
        contact.setFirstName("Zeddy");
        contact.setLastName("Isu");
        contact.setEmail("zeddy5000@gmail.com");
        Contact contact1 = new Contact();
        contact1.setPhoneNumber("07051875928");
        contact1.setFirstName("Helen");
        contact1.setLastName("Isu");
        contact1.setEmail("zeddy5000@gmail.com");
        contactRepository.save(contact);
        contactRepository.save(contact);
        assertEquals(1,contactRepository.count());

    }
    @Test
    public void saveContactCount_FindByIdTest(){
        ContactRepository contactRepository = new ContactRepositoryImpl();
        Contact contact = new Contact();
        contact.setPhoneNumber("07051875928");
        contact.setFirstName("Zeddy");
        contact.setLastName("Isu");
        contact.setEmail("zeddy5000@gmail.com");
        contactRepository.save(contact);
        assertEquals(1,contactRepository.count());
        Contact savedContact = contactRepository.findById(1);
        assertEquals("Zeddy",savedContact.getFirstName());

    }
    @Test
    public void deleteContacyById(){
        ContactRepository contactRepository = new ContactRepositoryImpl();
        Contact contact = new Contact();
        contact.setPhoneNumber("07051875928");
        contact.setFirstName("Zeddy");
        contact.setLastName("Isu");
        contact.setEmail("zeddy5000@gmail.com");
        Contact contact1 = new Contact();
        contact.setPhoneNumber("08027689173");
        contact.setFirstName("Helen");
        contact.setLastName("Isu");
        contact.setEmail("helen5000@gmail.com");
        contactRepository.save(contact);
        contactRepository.save(contact1);
        System.out.println(contactRepository.count());
        System.out.println(contact.getId());
        System.out.println(contact1.getId());
        contactRepository.delete(1);
        System.out.println(contactRepository.count());
        assertEquals(1,contactRepository.count());

    }
    @Test
    void deleteContactByObject(){
        ContactRepository contactRepository = new ContactRepositoryImpl();
        Contact contact = new Contact();
        contact.setPhoneNumber("07051875928");
        contact.setFirstName("Zeddy");
        contact.setLastName("Isu");
        contact.setEmail("zeddy5000@gmail.com");
        Contact contact1 = new Contact();
        contact.setPhoneNumber("08027689173");
        contact.setFirstName("Helen");
        contact.setLastName("Isu");
        contact.setEmail("helen5000@gmail.com");
        contactRepository.save(contact);
        contactRepository.save(contact1);
        contactRepository.delete(contact);
        assertEquals(1,contactRepository.count());

    }
    @Test
    public void iCanFindAllContscts(){
        ContactRepository contactRepository = new ContactRepositoryImpl();
        Contact contact = new Contact();
        contact.setPhoneNumber("07051875928");
        contact.setFirstName("Zeddy");
        contact.setLastName("Isu");
        contact.setEmail("zeddy5000@gmail.com");
        Contact contact1 = new Contact();
        contact.setPhoneNumber("08027689173");
        contact.setFirstName("Helen");
        contact.setLastName("Isu");
        contact.setEmail("helen5000@gmail.com");
        contactRepository.save(contact);
        contactRepository.save(contact1);
        Contact [] contacts = {contact,contact1};
        System.out.println(contactRepository.findAll());
    }


}