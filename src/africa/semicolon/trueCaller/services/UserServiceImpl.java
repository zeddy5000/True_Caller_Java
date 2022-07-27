package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.User;
import africa.semicolon.trueCaller.data.repositories.UserRepository;
import africa.semicolon.trueCaller.data.repositories.UserRepositoryImpl;
import africa.semicolon.trueCaller.dtos.requests.AddContactRequest;
import africa.semicolon.trueCaller.dtos.requests.RegisterRequest;
import africa.semicolon.trueCaller.dtos.responses.AddContactResponse;
import africa.semicolon.trueCaller.dtos.responses.RegisterResponse;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository = new UserRepositoryImpl();


    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        var savedUser = userRepository.findByEmail(registerRequest.getEmail());
        if (savedUser != null){
            throw new UserExistsException("user with"+ registerRequest.getEmail()+"already exists");
        }
        User user = new User();
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        user.setPhoneNumber(registerRequest.getPhoneNumber());
        userRepository.saveUser(user);
        RegisterResponse response = new RegisterResponse();
        response.setMessage("Registration successful");

        return response;
    }

    @Override
    public int getNumberOfUsers() {
        return userRepository.count();
    }

    @Override
    public AddContactResponse addContact(AddContactRequest request) {
        return null;
    }
}
