import java.util.ArrayList;;

public class Carrito {
    private ArrayList<Item> carrito;

    //setters
    
    public void setCarrito(ArrayList<Item> carrito){
        this.carrito = carrito;
    }

    //getters 
    public ArrayList<Item> getCarrito(){
        return this.carrito;
    }

    //metodos utiles

    public void addItem(String name, Float price){
        Item item = new Item();
        item.setName(name);
        item.setPrice(price);
        this.carrito.add(item);


    }

    public boolean removeItem(Item item){
        if (this.carrito.contains(item)) {
            this.carrito.remove(item);
            return true;
        }
        return false;
     }

    public void removeCarrito(){
        //recorremos todos los elmentos del carrito y los eliminamos
        this.carrito.removeAll(carrito);
    }
}
