//Se agregó esta clase de forma inesperada porque se había pensado en usar una variable para gestionar la caja
//pero no se pudo manejar ya que daba error con la variable loca, así que se tuvo que agregar esta clase para poder 
//almacenar el monto total vendido por las 3 localidades.

public class Caja {
    int caja;

    /**
     * @return el valor de la caja 
     */
    public int getCaja(){
        return this.caja;
    }

    /**
     * @param caja monto de la caja a sumar
     */
    public void setCaja(int caja){
        this.caja += caja;
    }
}
