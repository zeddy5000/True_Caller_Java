package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.repositories.UserRepository;
import africa.semicolon.trueCaller.data.repositories.UserRepositoryImpl;
import africa.semicolon.trueCaller.dtos.requests.AddContactRequest;
import africa.semicolon.trueCaller.dtos.requests.RegisterRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    private UserService userService;

    @BeforeEach
    void setUp(){
         userService = new UserServiceImpl();




    }




    @Test
    public void registerTest(){


        //given there is a request
        RegisterRequest request = new RegisterRequest();
        request.setFirstName("Zeddy");
        request.setLastName("Isu");
        request.setPhoneNumber("0705");
        request.setEmail("zeddy@gmail");
        request.setPassword("12345");
        //when i try to register user
        userService.register(request);//assert repository size is one
        assertEquals(1,userService.getNumberOfUsers());

    }
    @Test
    public void dublicateEmailThrowsException(){
        RegisterRequest request = new RegisterRequest();
        request.setFirstName("Zeddy");
        request.setLastName("Isu");
        request.setPhoneNumber("0705");
        request.setEmail("zeddy@gmail");
        request.setPassword("12345");
        //when i try to register user
        userService.register(request);
        RegisterRequest request1 = new RegisterRequest();
        request1.setFirstName("Zeddy");
        request1.setLastName("Isu");
        request1.setPhoneNumber("0705");
        request1.setEmail("zeddy@gmail");
        request1.setPassword("12345");
        //when i try to register user

        assertThrows(UserExistsException.class,()->userService.register(request1));
        assertEquals(1,userService.getNumberOfUsers());


    }

    @Test
    void addContactTest(){
        RegisterRequest request = new RegisterRequest();
        request.setFirstName("Zeddy");
        request.setLastName("Isu");
        request.setPhoneNumber("0705");
        request.setEmail("zeddy@gmail");
        request.setPassword("12345");
        //when i try to register user
        userService.register(request);
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName("Sammy");
        addContactRequest.setLastName("Isu");
        addContactRequest.setEmail("sammy@gmail.com");
        addContactRequest.setPhoneNumber("07051875928");
        addContactRequest.setUserEmail("zeddy5000@gmail");
        userService.addContact(addContactRequest);


    }

}