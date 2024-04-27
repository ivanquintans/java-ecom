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
        //TODO: funcion encargada de parsear las cosas, para que se pase el precio del item al parsear el nombre
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

    //aumentar cantidad o reducir de un elemento dado
    public void changeCantidad(String name,boolean aumentar){
        //iteramos los items, hasta encontrar que item es
        for (Item item : this.listItems){
            if (item.getName().equals(name)){
                //dependiendo si hay que aumentar o reducit
                int stock = item.getCantidad();
                if (aumentar){
                    item.setCantidad(stock +1 );
                }else{
                    item.setCantidad(stock-1);
                }
            }
        }
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
