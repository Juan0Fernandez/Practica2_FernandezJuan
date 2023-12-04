package ups.edu.ec.interfaz;

import java.util.Date;
//es una interfas 
public interface Prestable {
	public void prestar();//Metodo para prestar
    public void devolver();//Metodo para devolver
    public Date calcularFechaDevolucion();//Metodo para calcular fecha de devolucion
}
