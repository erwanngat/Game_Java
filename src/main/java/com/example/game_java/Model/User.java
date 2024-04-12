package com.example.game_java.Model;

public class User {
    private int id;
    private String email;
    private String password;
    private String passwordConfirmation;

    public User(String email, String password, String passwordConfirmation){
        this.email = email;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
    }

    public int getId(){
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getPasswordConfirmation() {
        return this.passwordConfirmation;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
