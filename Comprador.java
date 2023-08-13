public class Comprador{
    String nombre;
    String email;
    int cantidadBoletos;
    long presupuesto;
    int localidadAsignada; //Se agregó esta variable posterior al análisis, servirá para vincular la localidad asignada con el usuario

    /**
     * @param nombre nombre del usuario
     * @param email correo del usuario
     * @param cantidadBoletos cantidad de boletos del usuario
     * @param presupuesto  presupuesto actual del usuario
     */

    public Comprador(String nombre, String email, int cantidadBoletos, long presupuesto){
        this.nombre = nombre;
        this.email = email;
        this.cantidadBoletos = cantidadBoletos;
        this.presupuesto = presupuesto;
    }

    //Se agregó este método para poder setear la localidad del usuario
    //No se esperaba usar este método en el análisis
    /**
     * @param localidad la localidad asignada al usuario
     */
    public void setLocalidad(int localidad){
        this.localidadAsignada = localidad;
    }

    //Se agregó este método para poder obtener la localidad del usuario
    //No se esperaba usar este método en el análisis
    /**
     * @return la localidad asignada del usuario
     */
    public int getLocalidad(){
        return this.localidadAsignada;
    }


    /**
     * @return la cantidad de boletos a comprar
     */
    public int getCantidadBoletos(){
        return this.cantidadBoletos;
    }

    /**
     * @return el presupuesto del usuario
     */
    public long getPresupuesto(){
        return this.presupuesto;
    }


    /**
     * @return string el usuario
     */
    public String toString() {
        return "Nombre: " + this.nombre + "\nEmail:" + this.email + "\nCantidad de boletos a comprar: " + this.cantidadBoletos + "\nPresupuesto: " + this.presupuesto;
    }

    //Se agregó este método para poder personalizar mejor las respuestas
    //No se esperaba usar este método en el análisis
    /**
     * @return el nombre del usuario
     */
    public String getNombre(){
        return this.nombre;
    }
}