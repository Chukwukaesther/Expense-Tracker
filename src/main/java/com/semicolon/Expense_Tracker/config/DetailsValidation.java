package com.semicolon.Expense_Tracker.config;

public class DetailsValidation {

    public String validateEmail(String email) {
        boolean regex = email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        if (regex) {
            return email;
        }
        else {
            throw new IllegalArgumentException("Invalid Email");
        }
    }

    public String validateFirstName(String firstName) {
        boolean regex = firstName.matches("^[a-zA-Z]+([a-zA-Z0-9]( _ | - | \\\\. | , | # | \\\\+ ))[a-zA-Z0-9]+$");
        if (regex) {
            return firstName.toLowerCase();
        }
        else{
            throw new IllegalArgumentException("Invalid first name try again");
        }
    }

    public String validateLastName(String lastName) {
        boolean regex = lastName.matches("^[a-zA-Z]+([a-zA-Z0-9]( _ | - | \\\\. | , | # | \\\\+ ))[a-zA-Z0-9]+$");
        if (regex) {
            return lastName.toLowerCase();
        }
        else{
            throw new IllegalArgumentException("Invalid last name try again");
        }
    }

    public String validatePassword (String password) {
        boolean regex = password.matches("^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[@$!%?&])[A-Za-z\\d@$!%?&]{8,}$");
        if (regex) {
            return password;
        }

        else {
            throw new IllegalArgumentException("Invalid password try again");
        }
    }




}
