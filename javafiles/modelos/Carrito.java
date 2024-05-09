package modelos;
import java.util.ArrayList;
import java.util.Iterator;;

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
        //si el item ya existe en el arraylist, simplemente aumentamos la cantidad del item
        int flag = 0;
        for (Item item : this.listItems){
            if (item.getName().equals(name)){
                //si ya existe aumentamos la cantidad
                flag =1;
                int aux = item.getCantidad();
                item.setCantidad(cantidad + aux);
            }
        }
        //en otro caso, añadimos el item 
        if (flag==0){ //si no se encontro ningun elemento igual
            this.listItems.add(new Item(name, cantidad));
        }
    }

    public void removeItem(String name){
        Iterator<Item> iterador = this.getCarrito().iterator();
        while (iterador.hasNext()) {
            Item item = iterador.next();
            if (item.getName().equals(name)) { 
                iterador.remove(); 
                break; 
            }
        }
    }


     //recorremos todos los elmentos del carrito y los eliminamos

    public void removeCarrito(){
        this.listItems.removeAll(listItems);
    }
}
