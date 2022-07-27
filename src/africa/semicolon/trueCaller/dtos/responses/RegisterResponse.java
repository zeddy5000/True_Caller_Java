package africa.semicolon.trueCaller.dtos.responses;

import africa.semicolon.trueCaller.data.repositories.UserRepository;
import africa.semicolon.trueCaller.data.repositories.UserRepositoryImpl;

public class RegisterResponse {
    private UserRepository userRepository = new UserRepositoryImpl();
    private  String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
