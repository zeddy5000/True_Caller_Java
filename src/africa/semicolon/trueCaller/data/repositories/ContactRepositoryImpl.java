package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository{
    private ArrayList<Contact> listOfContact = new ArrayList<>();
    int counter = 0;
    @Override
    public Contact save(Contact contact) {
   var contactId = contact.getId();
   for(Contact value : listOfContact){
       if(value.getId() == contactId){
           contact.setFirstName(contact.getFirstName());
           contact.setLastName(contact.getFirstName());
           contact.setEmail(contact.getEmail());
           contact.setPhoneNumber(contact.getPhoneNumber());
           return value;
       }
   }
        counter++;
        contact.setId(counter);
        listOfContact.add(contact);


        return contact;
    }

    @Override
    public void delete(Contact contact) {
        for(int i = 0; i < listOfContact.size(); i++){
            if(listOfContact.get(i).equals(contact)){
                listOfContact.remove(contact);
            }
        }

    }

    @Override
    public void delete(int id) {
        for(int i = 0 ; i < listOfContact.size(); i++){
            if(listOfContact.get(i).equals(listOfContact.get(id))){
                listOfContact.remove(id-1);
            }
        }
    }

    @Override
    public Contact findById(int id) {
        for (var contact : listOfContact){
            if(contact.getId() == id){
                return contact;
            }
        }
        return null;
    }

    @Override
    public List<Contact> findAll() {
        ArrayList<Contact> contacts = new ArrayList<>();
        for(int i = 0 ; i < listOfContact.size(); i++){
            contacts.add(listOfContact.get(i));
        }

        return contacts ;
    }

    @Override
    public int count() {
        return listOfContact.size();
    }
}
