public class Localidad {
    int tipo;
    int espacio;
    int precio;

    public Localidad(int tipo, int espacio, int precio){
        this.tipo = tipo;
        this.espacio = espacio;
        this.precio = precio;
    }

    //Se agregó este método para poder restar la cantidad del espacio y tener el nuevo espacio
    //No se esperaba usar este método en el análisis
    public void setEspacio(int nuevoEspacio){
        this.espacio = this.espacio-nuevoEspacio;
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
