package ups.edu.ec.clases;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import ups.edu.ec.interfaz.Prestable;

public class Libro implements Prestable{
	    private String titulo;
	    private String autor;			//Atributos de la clase Libro
	    private int año;
	    private boolean disponible = true;

		public Libro(String titulo, String autor, int año, boolean disponible) {
			super();
			this.titulo = titulo;
			this.autor = autor;				//Constructor de la clase libro
			this.año = año;
			this.disponible = disponible;
		}
		//metodos de encapsulamiento
		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public String getAutor() {
			return autor;
		}
		public void setAutor(String autor) {
			this.autor = autor;
		}
		public int getAño() {
			return año;
		}
		public void setAño(int año) {
			this.año = año;
		}
		public boolean isDisponible() {
			return disponible;
		}
		public void setDisponible(boolean disponible) {
			this.disponible = disponible;
		}

		//hashCode y equals
		@Override
		public int hashCode() {
			return Objects.hash(titulo);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Libro other = (Libro) obj;
			return Objects.equals(titulo, other.titulo);
		}

		//Metodo sobreescrito de la interface Prestable
		@Override
	    public void prestar() {
	        if (disponible) {
	            System.out.println("Libro prestado: " + titulo);
	            disponible = false;
	        } else {
	            System.out.println("Libro no disponible para préstamo: " + titulo);
	        }
	    }

		//Metodo sobreescrito de la interface Prestable
	    @Override
	    public void devolver() {
	        System.out.println("Libro devuelto: " + titulo);
	        disponible = true;
	    }
	    //Metodo para mostrar informacion
	    public void mostrarInformacion() {
	        System.out.println("Título: " + titulo);
	        System.out.println("Autor: " + autor);
	        System.out.println("Año: " + año);
	        System.out.println("Disponible: " + (disponible ? "Sí" : "No"));
	    }

	    //Metodo para calcular informacion 
		@Override
		public Date calcularFechaDevolucion() {
			// Lógica para calcular la fecha de devolución
		    Calendar calendar = Calendar.getInstance();
		    calendar.setTime(new Date());
		    calendar.add(Calendar.DAY_OF_MONTH, 30);
		    return calendar.getTime();
			
		}
	    
	    
}