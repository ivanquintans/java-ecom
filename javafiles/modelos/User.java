package modelos;

public class User {
    private String email;
    private String password;
    private String cardType;
    private int cardNumber;

    //constructor para el login, y constructor para registrarse

    public User(String email, String password) {
        this.email = email;
        this.password =  password;
    }

    public User(String email, String password, String cardType, int cardNumber) {
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
    public int getCardNumber() {
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
    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    

    
    
}
