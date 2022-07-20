package africa.semicolon.trueCaller.data.repositories;


import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.models.User;

import java.util.List;

public interface UserRepository {
    User saveUser (User user);
    void deleteUser(User user);
     void deleteUser(int id);
    User findById(int id);
    int count();
     List<User> findAll();
     Contact addContact(Contact contact);
}
