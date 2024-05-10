package modelos;

import java.math.BigInteger;

public class User {
    private String email;
    private String password;
    private String cardType;
    private String cardNumber;

    //constructor para el login, y constructor para registrarse

    public User(String email, String password) {
        this.email = email;
        this.password =  password;
    }

    public User(String email, String password, String cardType, String cardNumber) {
        this.email = email;
        this.password =  password;
        this.cardType = cardType;
        this.cardNumber = cardNumber;
    }
    
    //getters and setters
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getCardType() {
        return cardType;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    

    
    
}
