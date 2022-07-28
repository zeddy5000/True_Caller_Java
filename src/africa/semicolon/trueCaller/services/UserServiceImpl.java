package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.models.User;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.data.repositories.ContactRepositoryImpl;
import africa.semicolon.trueCaller.data.repositories.UserRepository;
import africa.semicolon.trueCaller.data.repositories.UserRepositoryImpl;
import africa.semicolon.trueCaller.dtos.requests.AddContactRequest;
import africa.semicolon.trueCaller.dtos.requests.RegisterRequest;
import africa.semicolon.trueCaller.dtos.responses.AddContactResponse;
import africa.semicolon.trueCaller.dtos.responses.RegisterResponse;
import africa.semicolon.trueCaller.exceptions.UserExistsException;
import africa.semicolon.trueCaller.utils.Mapper;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ContactService contactService;

    public UserServiceImpl(ContactService contactService,UserRepository userRepository) {
        this.contactService = contactService;
        this.userRepository = userRepository;

    }
    public UserServiceImpl() {

        this.contactService = new ContactServiceImpl();
        this.userRepository = new UserRepositoryImpl();
        ContactRepository contactRepository = new ContactRepositoryImpl();

    }


    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        User user = new User();
        isExist(registerRequest.getEmail());
        Mapper.map(registerRequest,user);
        userRepository.saveUser(user);
        RegisterResponse response = new RegisterResponse();
        response.setMessage("Registration successful");

        return response;
    }

    private void isExist(String emailAdress) {
        var savedUser = userRepository.findByEmail(emailAdress);
        if (savedUser != null){
            throw new UserExistsException("user with"+ emailAdress+"already exists");
        }
    }

    @Override
    public int getNumberOfUsers() {
        return userRepository.count();
    }

    @Override
    public AddContactResponse addContact(AddContactRequest addContactResponse) {
        Contact contact = new Contact();
        contact.setFirstName(addContactResponse.getFirstName());
        contact.setLastName(addContactResponse.getLastName());
        contact.setPhoneNumber(addContactResponse.getPhoneNumber());
        contact.setEmail(addContactResponse.getEmail());
        Contact savedContact = contactService.addNewContact(contact);
        User user = userRepository.findByEmail(addContactResponse.getUserEmail());
        user.getContactList().add(savedContact);
        userRepository.saveUser(user);
        return null;
    }

    @Override
    public List<Contact> findContactsBelongingto(String userEmail) {
        User user = userRepository.findByEmail(userEmail);

        return user.getContactList();
    }
}
