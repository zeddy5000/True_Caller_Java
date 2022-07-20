package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;

import java.util.List;

public interface ContactRepository {
    Contact save(Contact contact);
    void delete(Contact contact);
    void delete(int id);
    Contact findById(int id);
  //  List<Contact> findByFirstName(String firstName);
    List<Contact> findAll();
    int count();
}
