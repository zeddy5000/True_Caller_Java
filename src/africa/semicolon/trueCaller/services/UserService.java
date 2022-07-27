package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.dtos.requests.RegisterRequest;
import africa.semicolon.trueCaller.dtos.requests.AddContactRequest;
import africa.semicolon.trueCaller.dtos.responses.AddContactResponse;
import africa.semicolon.trueCaller.dtos.responses.RegisterResponse;

public interface UserService {
    RegisterResponse register(RegisterRequest request);

    int getNumberOfUsers();

    AddContactResponse addContact(AddContactRequest request);
}
