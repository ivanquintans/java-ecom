public class Item {

    private String name;
    private int cantidad;

    //constructor de item

    public Item (String name, int cantidad){
        this.name = name;
        this.cantidad = cantidad;
    }

    //setters
    public void setName(String name){
        this.name = name;
    }

    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    //getters

    public String getName(){
        return this.name;
    }

    public int getCantidad(){
        return this.cantidad;
    }
}

