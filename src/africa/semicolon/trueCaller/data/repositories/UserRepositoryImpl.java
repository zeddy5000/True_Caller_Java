package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.models.User;
import africa.semicolon.trueCaller.services.UserExistsException;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository{


    private int counter;
    private ArrayList<User> users = new ArrayList<>();


    @Override
    public User saveUser(User user) {
       // var userId = user.getId();
        for(User value : users){
            if(value.getId() == user.getId() ){
                value = user;
              //  user.setFirstName(user.getFirstName());
                //user.setLastName(user.getFirstName());
                //user.setEmail(user.getEmail());
                //user.setPhoneNumber(user.getPhoneNumber());
                return value;
            }
        }
        counter++;
        user.setId(counter);
        users.add(user);
        return user;
    }

    @Override
    public void deleteUser(User user) {
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).equals(user)){
                users.remove(user);
            }
        }


    }

    @Override
    public void deleteUser(int id) {
        for(int i = 0 ; i < users.size(); i++){
            if(users.get(i).equals(users.get(id))){
                users.remove(id-1);
            }
        }

    }

    @Override
    public User findById(int id) {
        for(User user : users){
            if(user.getId() == id)return user;
        }
        return null;
    }

    @Override
    public int count() {
        return users.size();
    }

    @Override
    public List<User> findAll() {
        ArrayList<User> allUsers = new ArrayList<>();
        for(int i = 0 ; i < users.size(); i++){
            allUsers.add(users.get(i));
        }

        return allUsers;
    }

    @Override
    public User findByEmail(String email) {
        for( var user: users){
            if(user.getEmail().equalsIgnoreCase(email)){
                return user;
            }
        }

        return null;
    }



    @Override
    public Contact addContact(Contact contact) {
        return null;
    }

}
