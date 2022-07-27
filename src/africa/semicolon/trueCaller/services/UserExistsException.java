package africa.semicolon.trueCaller.services;

public class UserExistsException extends RuntimeException{
    public UserExistsException(String message){
        super(message);

    }
}
