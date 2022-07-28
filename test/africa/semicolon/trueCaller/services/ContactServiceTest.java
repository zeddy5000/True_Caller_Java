package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {
    private ContactService contactService;
    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    void setUp(){
        contactService = new ContactServiceImpl();
       // userRepository = new

    }
    @Test
    void addNewContact(){
        Contact contact = new Contact();
        contact.setPhoneNumber("07051875928");
        contact.setFirstName("zeddy");
        contact.setLastName("Isu");
        contact.setEmail("zeddy@gmail");

        var savedContact = contactService.addNewContact(contact);
    }

}