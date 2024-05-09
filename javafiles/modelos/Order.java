package modelos;

public class Order {
    private int orderId;
    private String userEmail;
    private Float amount;

    public Order(int orderId, String userEmail, Float amount) {
        this.orderId = orderId;
        this.userEmail = userEmail;
        this.amount = amount;
    }
    
    //getters and setters
    public int getOrderId() {
        return orderId;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public Float getAmount() {
        return amount;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public void setAmount(Float amount) {
        this.amount = amount;
    }
    

    

    
}
