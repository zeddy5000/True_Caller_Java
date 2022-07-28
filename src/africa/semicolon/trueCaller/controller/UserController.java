package africa.semicolon.trueCaller.controller;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.dtos.requests.AddContactRequest;
import africa.semicolon.trueCaller.dtos.requests.RegisterRequest;
import africa.semicolon.trueCaller.dtos.responses.AddContactResponse;
import africa.semicolon.trueCaller.dtos.responses.RegisterResponse;
import africa.semicolon.trueCaller.services.UserService;
import africa.semicolon.trueCaller.services.UserServiceImpl;

import java.util.List;

public class UserController {
    private UserService userService = new UserServiceImpl();

    public RegisterResponse registerUser(RegisterRequest registerRequest){
        return userService.register(registerRequest);

    }
    public AddContactResponse addContact(AddContactRequest addContactRequest){
        return userService.addContact(addContactRequest);

    }
    public List<Contact> findContactBelongingTo(String email){
        return  userService.findContactsBelongingto(email);
    }

}
