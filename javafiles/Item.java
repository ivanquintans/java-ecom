import java.util.StringTokenizer;

public class Item {

    private String name;
    private int cantidad;
    private Float price;

    //constructor de item

    public Item (String name, int cantidad){
        //llamamos al parser que se encarga de pillar el precio
        this.price= parserPrice(name);
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

    public void setPrice(Float price){
        this.price = price;
    }

    //getters

    public String getName(){
        return this.name;
    }

    public int getCantidad(){
        return this.cantidad;
    }

    public Float getPrice(){
        return this.price;
    }

    public Float parserPrice(String name){
        //importamos el string tokenizer para parsear el nombre
        StringTokenizer tokenizer = new StringTokenizer(name,"|");
        tokenizer.nextToken(); //obviamos el artista
        tokenizer.nextToken(); //obviamos el nombre
        tokenizer.nextToken(); //obviamos el pais del cd
        //asignamos el precio al valor 
        String precioString = tokenizer.nextToken();
        precioString = precioString.replace("$", "").trim(); // Reemplazamos '$' con una cadena vacía y luego eliminamos los espacios en blanco alrededor

        // Convertir precioString a float
        float precio = Float.parseFloat(precioString);
        return precio;
    }
}

