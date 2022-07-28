package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.dtos.requests.RegisterRequest;
import africa.semicolon.trueCaller.dtos.requests.AddContactRequest;
import africa.semicolon.trueCaller.dtos.responses.AddContactResponse;
import africa.semicolon.trueCaller.dtos.responses.RegisterResponse;

import java.util.Collection;
import java.util.List;

public interface UserService {
    RegisterResponse register(RegisterRequest request);

    int getNumberOfUsers();

    AddContactResponse addContact(AddContactRequest request);

    List<Contact> findContactsBelongingto(String userEmail);


}
