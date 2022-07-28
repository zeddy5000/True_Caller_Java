package africa.semicolon.trueCaller.utils;

import africa.semicolon.trueCaller.data.models.User;
import africa.semicolon.trueCaller.dtos.requests.RegisterRequest;

public class Mapper {
    public static void map(RegisterRequest registerRequest, User user) {
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        user.setPhoneNumber(registerRequest.getPhoneNumber());
    }
}
