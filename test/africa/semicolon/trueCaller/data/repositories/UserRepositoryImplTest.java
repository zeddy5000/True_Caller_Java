package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.models.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    @Test
    void userCanBeAdded(){
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();
        user.setPhoneNumber("07051875928");
        user.setFirstName("Zeddy");
        user.setLastName("Isu");
        user.setEmail("zeddy5000@gmail.com");
        userRepository.saveUser(user);
        assertEquals(1,userRepository.count());

    }
    @Test
    void iCanDeleteUserById(){
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();
        user.setPhoneNumber("07051875928");
        user.setFirstName("Zeddy");
        user.setLastName("Isu");
        user.setEmail("zeddy5000@gmail.com");
        User user1 = new User();
        user1.setPhoneNumber("07051875928");
        user1.setFirstName("Helen");
        user1.setLastName("Isu");
        user1.setEmail("zeddy5000@gmail.com");
        userRepository.saveUser(user);
        userRepository.saveUser(user1);
        userRepository.deleteUser(1);
        assertEquals(1,userRepository.count());

    }
    @Test
    void userCanBeDeletedByObject(){
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();
        user.setPhoneNumber("07051875928");
        user.setFirstName("Zeddy");
        user.setLastName("Isu");
        user.setEmail("zeddy5000@gmail.com");
        User user1 = new User();
        user1.setPhoneNumber("07051875928");
        user1.setFirstName("Helen");
        user1.setLastName("Isu");
        user1.setEmail("zeddy5000@gmail.com");
        userRepository.saveUser(user);
        userRepository.saveUser(user1);
        userRepository.deleteUser(user);
        assertEquals(1,userRepository.count());

    }
    @Test
    void userCanBeFoundById(){
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();
        user.setPhoneNumber("07051875928");
        user.setFirstName("Zeddy");
        user.setLastName("Isu");
        user.setEmail("zeddy5000@gmail.com");
        User user1 = new User();
        user1.setPhoneNumber("07051875928");
        user1.setFirstName("Helen");
        user1.setLastName("Isu");
        user1.setEmail("zeddy5000@gmail.com");
        userRepository.saveUser(user);
        userRepository.saveUser(user1);
        User search = userRepository.findById(1);
        assertEquals(user,search);
    }
    @Test
    void iCanFindAllUsers(){
        UserRepository userRepository = new UserRepositoryImpl();
        User user = new User();
        user.setPhoneNumber("07051875928");
        user.setFirstName("Zeddy");
        user.setLastName("Isu");
        user.setEmail("zeddy5000@gmail.com");
        User user1 = new User();
        user1.setPhoneNumber("07051875928");
        user1.setFirstName("Helen");
        user1.setLastName("Isu");
        user1.setEmail("zeddy5000@gmail.com");
        userRepository.saveUser(user);
        userRepository.saveUser(user1);
        List<User> allUsers = userRepository.findAll();
        System.out.println(allUsers);

    }
    @Test
    void aUserCanAddContact(){

    }

}