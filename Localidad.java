public class Localidad {
    int tipo;
    int espacio;
    int precio;

    public Localidad(int tipo, int espacio, int precio){
        this.tipo = tipo;
        this.espacio = espacio;
        this.precio = precio;
    }

    public int getEspacio(){
        return espacio;
    }

    public int getPrecio(){
        return precio;
    }

    public int getTipo(){
        return tipo;
    }



}
