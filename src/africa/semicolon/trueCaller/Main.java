package africa.semicolon.trueCaller;

import africa.semicolon.trueCaller.controller.UserController;
import africa.semicolon.trueCaller.dtos.requests.AddContactRequest;
import africa.semicolon.trueCaller.dtos.requests.RegisterRequest;

import java.util.Scanner;

public class Main {
    private static final Scanner keyBoardInput = new Scanner(System.in);
    private static UserController userController = new UserController();
    public static void main(String[] args) {
        // prompt user with menu
        //if user selects a,b,c,d direct them
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
            display(contact.toString());
        }
        contacts.forEach(contact -> display(contact.toString()));
        mainMenu();
    }

    private static void addContactToUser() {
        AddContactRequest addContactRequest = new AddContactRequest();
        addContactRequest.setFirstName(input("Enter firstName"));
        addContactRequest.setLastName("Enter contact's lastname");
        addContactRequest.setEmail("Enter contact's email");
        addContactRequest.setPhoneNumber("Enter contacts phonenumber");
        addContactRequest.setUserEmail("Enter your email");
        userController.addContact(addContactRequest);
        mainMenu();
    }
}
