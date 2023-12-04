package ups.edu.ec.clases;

import java.util.Objects;

public abstract class Persona {
	protected String nombre;
	//atributos de clase abstracta persona
	protected String identificacion;
    	
    public Persona() {
		super();//constructor vacio de clase abstracta persona
	}
    
    
	public Persona(String nombre, String identificacion) {
		super();
		this.nombre = nombre;
		this.identificacion = identificacion;
	}

	//metodos de encapsulamiento

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}	
	
	//Metodo hashCode y equals
	@Override
	public int hashCode() {
		return Objects.hash(identificacion);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(identificacion, other.identificacion);
	}


	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", identificacion=" + identificacion + "]";
	}


	public abstract void mostrarInformacion();
    //Metodo abstracto que se usara en la calse usuario
    
}
