package africa.semicolon.trueCaller;

import africa.semicolon.trueCaller.controller.UserController;
import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.dtos.requests.AddContactRequest;
import africa.semicolon.trueCaller.dtos.requests.RegisterRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;
@SpringBootApplication
public class Main {
    private static final Scanner keyBoardInput = new Scanner(System.in);
    private static UserController userController = new UserController();
    public static void main(String[] args) {
        // prompt user with menu
        //if user selects a,b,c,d direct them
        SpringApplication.run(Main.class,args);
        mainMenu();
    }

    private static void createAccount(){
        RegisterRequest request = new RegisterRequest();
        request.setFirstName(input("Enter your firstName"));
        request.setLastName(input("Enter your lastName"));
        request.setPhoneNumber(input("Enter your phoneNumber"));
        request.setEmail(input("Enter your email"));
        request.setPassword("Choose a password");
        userController.registerUser(request);
        display("Done!!!");
        mainMenu();
    }
    private static String display(String message){
        return message;
    }

    private static  String input(String prompt){
        System.out.println(prompt);
        return keyBoardInput.nextLine();
    }

    private static void mainMenu() {
        String mainMenuPrompt = """
                Welcome to Fake Caller
                1-> Create an Account
                2-> Add Contact
                3-> Find contact belonging to  A User
                """;
        System.out.println(mainMenuPrompt);
        String userInput = keyBoardInput.nextLine();
        switch (userInput.charAt(0)) {
            case '1' -> createAccount();
            case '2' -> addContactToUser();
            case '3' -> findContactBelongingToUser();
        }
    }

    private static void findContactBelongingToUser() {
        var contacts = userController.findContactBelongingTo(input("Enter your email"));
        for (var contact : contacts){
            System.out.println(contact);
        }
     //   contacts.forEach(contact -> display(contact.toString()));
        mainMenu();

    }

    private static void addContactToUser() {
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName(input("Enter firstName"));
        addContactRequest.setLastName(input("Enter contact's lastname"));
        addContactRequest.setEmail(input("Enter contact's email"));
        addContactRequest.setPhoneNumber(input("Enter contacts phonenumber"));
        addContactRequest.setUserEmail(input("Enter your email"));
        userController.addContact(addContactRequest);
        System.out.println("contact sucessfully added");
        System.out.println();
        mainMenu();
    }
}
