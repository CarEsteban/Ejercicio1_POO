public class Comprador{
    String nombre;
    String email;
    int cantidadBoletos;
    long presupuesto;
    int boletosVendidos;

    public Comprador(String nombre, String email, int cantidadBoletos, long presupuesto){
        this.nombre = nombre;
        this.email = email;
        this.cantidadBoletos = cantidadBoletos;
        this.presupuesto = presupuesto;
    }

    public void setBoletosVendidos(int boletosVendidos){
        this.boletosVendidos = boletosVendidos;
    }

    public int getBoletosVendidos(){
        return boletosVendidos;
    }

    public String toString() {
        return "Nombre: " + this.nombre + "\nEmail:" + this.email + "\nCantidad de boletos a comprar: " + this.cantidadBoletos + "\nPresupuesto: " + this.presupuesto;
    }













}