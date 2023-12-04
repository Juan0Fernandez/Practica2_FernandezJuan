package ups.edu.ec.clases;

import java.util.ArrayList;
import java.util.Date;

public class Usuario extends Persona {
	String correo;				//Atributos de la clase Usuario
    ArrayList<Prestamo> listaPrestamos = new ArrayList<>();
    
    public Usuario(String nombre, String identificacion,String correo) {
    	// Constructor que utiliza atributos de la clase abstracta Persona y el atributo específico de Usuario (correo)
		super(nombre, identificacion);
		this.correo = correo; // Asignación del correo proporcionado al atributo de la clase Usuario
		   
	}
    
	public void agregarPrestamo(Prestamo prestamo) {
		// Método para agregar un préstamo a la lista de préstamos del usuario
		listaPrestamos.add(prestamo);
    }
	
    public void eliminarPrestamo(Prestamo prestamo) {
    	// Método para eliminar un préstamo de la lista de préstamos del usuario
        listaPrestamos.remove(prestamo);
    }
    
    
    @Override
    // Implementación del método abstracto mostrarInformacion de la clase Persona
    public void mostrarInformacion() {
        System.out.println("Información del Usuario:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Identificación: " + identificacion);
        System.out.println("Correo: " + correo);
    }

 // Método para devolver un libro que ha sido prestado al usuario
    public void devolverLibro(Libro libro) {
        Prestamo prestamo = listaPrestamos.stream()
                .filter(p -> p.getLibro().equals(libro))
                .findFirst()
                .orElse(null);
        // Verificar si el préstamo es vigente y devolver el libro
        if (prestamo != null && prestamo.esPrestamoVigente()) {
            listaPrestamos.remove(prestamo);
            prestamo.getLibro().setDisponible(true);
        } else {
            System.out.println("Error al devolver el libro. Verifique que el libro esté en préstamo y el préstamo sea vigente.");
        }
    }

}
