public class Localidad {
    int tipo;
    int espacio;
    int precio;

    /**
     * @param tipo tipo de localidad (1,5,10)
     * @param espacio cantidad de espacio de la localidad
     * @param precio precio de la localidad
     */
    public Localidad(int tipo, int espacio, int precio){
        this.tipo = tipo;
        this.espacio = espacio;
        this.precio = precio;
    }

    //Se agregó este método para poder restar la cantidad del espacio y tener el nuevo espacio
    //No se esperaba usar este método en el análisis
    /**
     * @param nuevoEspacio valor del espacio comprado
     */
    public void setEspacio(int nuevoEspacio){
        this.espacio = this.espacio-nuevoEspacio;
    }

    /**
     * @return espacio de la localidad
     */
    public int getEspacio(){
        return espacio;
    }

    /**
     * @return precio de la localidad
     */
    public int getPrecio(){
        return precio;
    }

    /**
     * @return tipo de la localidad
     */
    public int getTipo(){
        return tipo;
    }



}
