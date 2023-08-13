public class Comprador{
    String nombre;
    String email;
    int cantidadBoletos;
    long presupuesto;
    int localidadAsignada; //Se agregó esta variable posterior al análisis, servirá para vincular la localidad asignada con el usuario

    public Comprador(String nombre, String email, int cantidadBoletos, long presupuesto){
        this.nombre = nombre;
        this.email = email;
        this.cantidadBoletos = cantidadBoletos;
        this.presupuesto = presupuesto;
    }

    //Se agregó este método para poder setear la localidad del usuario
    //No se esperaba usar este método en el análisis
    public void setLocalidad(int localidad){
        this.localidadAsignada = localidad;
    }

    //Se agregó este método para poder obtener la localidad del usuario
    //No se esperaba usar este método en el análisis
    public int getLocalidad(){
        return this.localidadAsignada;
    }


    public int getCantidadBoletos(){
        return this.cantidadBoletos;
    }

    public long getPresupuesto(){
        return this.presupuesto;
    }


    public String toString() {
        return "Nombre: " + this.nombre + "\nEmail:" + this.email + "\nCantidad de boletos a comprar: " + this.cantidadBoletos + "\nPresupuesto: " + this.presupuesto;
    }

    //Se agregó este método para poder personalizar mejor las respuestas
    //No se esperaba usar este método en el análisis
    public String getNombre(){
        return this.nombre;
    }










}