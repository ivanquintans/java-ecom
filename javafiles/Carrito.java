import java.util.ArrayList;;

public class Carrito {
    private ArrayList<Item> listItems;

    //constructor

    public Carrito(){
        this.listItems = new ArrayList<>();
    }

    //setters
    public void setCarrito(ArrayList<Item> carrito){
        this.listItems = carrito;
    }

    //getters 
    public ArrayList<Item> getCarrito(){
        return this.listItems;
    }

    //metodos utiles

    public void addItem(String name, int cantidad){
        this.listItems.add(new Item(name, cantidad));
    }

    public boolean removeItem(Item item){
        if (this.listItems.contains(item)) {
            this.listItems.remove(item);
            return true;
        }
        return false;
     }
     //recorremos todos los elmentos del carrito y los eliminamos

    public void removeCarrito(){
        this.listItems.removeAll(listItems);
    }
}
