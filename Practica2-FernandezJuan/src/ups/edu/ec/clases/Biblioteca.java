package ups.edu.ec.clases;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class Biblioteca {
	private String nombre;
	private String direccion;
	private ArrayList<Libro> listaLibros = new ArrayList<>();			//Atributos de la clase Biblioteca
	private ArrayList<Usuario> listaUsuarios = new ArrayList<>();	
    private ArrayList<Prestamo> listaPrestamos = new ArrayList<>();
	
	public Biblioteca() {
		super();	//contructor vacio
	}	
	public Biblioteca(String nombre, String direccion) {
		super();
		this.nombre = nombre;	//contructor con el nombre y direccion de la clase 
		this.direccion = direccion;
		// Agrego libros a la Biblioteca cuando es creada
        agregarLibro(new Libro("El señor de los anillos", "J.R.R. Tolkien", 1954, true));
        agregarLibro(new Libro("Cien años de soledad", "Gabriel García Márquez", 1967, true));
        agregarLibro(new Libro("To Kill a Mockingbird", "Harper Lee", 1960, true));
        agregarLibro(new Libro("The Great Gatsby", "JF. Scott Fitzgerald", 1925, true));
        agregarLibro(new Libro("One Hundred Years of Solitude", "Gabriel García Márquez", 1967, true));
        agregarLibro(new Libro("Brave New World", "Aldous Huxley", 1932, true));
        agregarLibro(new Libro("The Catcher in the Rye", "J.D. Salinger", 1951, true));
        agregarLibro(new Libro("The Lord of the Rings", "J.R.R. Tolkien", 1955, true));
        agregarLibro(new Libro("Pride and Prejudice", "Jane Austen", 1954, true));
        agregarLibro(new Libro("The Hobbit", "J.R.R. Tolkien", 1937, true));
        // Agrego usuarios a la Biblioteca cuando es creada
        registrarUsuario(new Usuario("Juan Fernandez", "0101010101", "Fernandez@gmail.com"));
        registrarUsuario(new Usuario("Pablo Perez", "0202020202", "Perez@hotmail.com"));
    	}
	public Biblioteca(String nombre, String direccion, ArrayList<Libro> listaLibros,
			ArrayList<Usuario> listaUsuarios, ArrayList<Prestamo> listaPrestamos) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.listaLibros = listaLibros;			//Constructor con todos los atributos de biblioteca
		this.listaUsuarios = listaUsuarios;
		this.listaPrestamos = listaPrestamos;
		}	
	
	//metodos de encapsulamiento
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public ArrayList<Libro> getListaLibros() {
		return listaLibros;
	}
	public void setListaLibros(ArrayList<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}
	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}
	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
   
    public ArrayList<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }
	
	
	//metodo de hasCode y equals 
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Biblioteca other = (Biblioteca) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	//metodo agregarLibro
	public void agregarLibro(Libro libro) {
        listaLibros.add(libro);
    }
//metodo para registrar un usuario
    public void registrarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }
//metodo para buscar un libro 
    public Libro buscarLibro(String titulo) {
        return listaLibros.stream()
                .filter(libro -> libro.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }

    //metodo implementado para obtener libros disponibles
    public ArrayList<Libro> obtenerLibrosDisponibles() {
        return (ArrayList<Libro>) listaLibros.stream().filter(Libro::isDisponible).collect(Collectors.toList());
    }
    
    //metodo PrestarLibro
    public void prestarLibro(Libro libro, Usuario usuario) {
        if (libro.isDisponible()) {
            Prestamo nuevoPrestamo = new Prestamo(libro, usuario);
            listaPrestamos.add(nuevoPrestamo);
            libro.setDisponible(false);
            usuario.agregarPrestamo(nuevoPrestamo);
        } else {
            System.out.println("El libro no está disponible para préstamo en este momento.");
        }
    }


    public Prestamo buscarPrestamoPorLibro(String tituloLibro) {
        return listaPrestamos.stream()
                .filter(prestamo -> prestamo.getLibro().getTitulo().equalsIgnoreCase(tituloLibro))
                .findFirst()
                .orElse(null);
    }

    public void devolverLibro(Prestamo prestamo) {
        prestamo.getLibro().setDisponible(true);
        listaPrestamos.remove(prestamo);
        prestamo.getUsuario().eliminarPrestamo(prestamo);
    }
}
