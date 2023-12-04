package ups.edu.ec.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ups.edu.ec.clases.Biblioteca;
import ups.edu.ec.clases.Libro;
import ups.edu.ec.clases.Prestamo;
import ups.edu.ec.clases.Usuario;


public class Main {

    public static void main(String[] args) {
    	// Crear una instancia de la clase Biblioteca con nombre "Biblioteca Central" y ubicación "El vecino"
        Biblioteca biblioteca = new Biblioteca("Biblioteca UPS", "El vecino");
        
        // Crear un objeto Scanner para el ingreso por consola
        Scanner entrada = new Scanner(System.in);
        
        // Variable para almacenar la opciónque ingresa el usuario
        int opcion;

        // Menú principal
        do {
            System.out.println("Bienvenido al Sistema de Gestión de  Biblioteca");
            System.out.println("1. Agregar Libro");
            System.out.println("2. Registrar Usuario");
            System.out.println("3. Buscar Libro");
            System.out.println("4. Prestar Libro");
            System.out.println("5. Devolver Libro");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            
            // Leer la opción del usuario
            opcion = entrada.nextInt();
            entrada.nextLine(); // Consumir la nueva línea

            // Switch para manejar el menu 
            switch (opcion) {
                case 1:
                    // Agregar Libros al sistema
                    System.out.println("¿Cuántos libros quiere agregar?");
                    int cantidadLibros = entrada.nextInt();
                    entrada.nextLine(); // Consumir la nueva línea

                    for (int i = 0; i < cantidadLibros; i++) {
                    	
                    	//Ingreso de Titulo,autor y Año de publicacion
                        System.out.println("Ingrese título del libro " + (i + 1) + ": ");
                        String titulo = entrada.nextLine();

                        System.out.println("Ingrese autor del libro " + (i + 1) + ": ");
                        String autor = entrada.nextLine();

                        System.out.println("Ingrese año de publicación del libro " + (i + 1) + ": ");
                        int añoPublicacion = entrada.nextInt();
                        entrada.nextLine(); // Consumir la nueva línea

                        /* Crear un nuevo objeto Libro y agregarlo a la biblioteca al rato de agregar 
                         ya se agrega como disponible ya que recien se hace el ingreso del libro*/
                        Libro nuevoLibro = new Libro(titulo, autor, añoPublicacion, true);
                        biblioteca.agregarLibro(nuevoLibro);
                    }
                    //pregunta al usuario si desea ver la lista de libros
                    System.out.println("¿Desea ver la lista de Libros? (Sí/No)");
                    String respuesta = entrada.nextLine();

                    // Verificar la respuesta del usuario
                    if (respuesta.trim().equalsIgnoreCase("si")) {
                        // Mostrar la lista completa de usuarios
                        System.out.println("Lista completa de Libros:");
                        for (Libro libro : biblioteca.getListaLibros()) {
                            libro.mostrarInformacion();
                            System.out.println("-----------------------------------------");
                        }
                    } else {
                        System.out.println("No se mostrará la lista de Libros.");
                    }
                    break;

                case 2:
                    // Registrar Usuarios en el sistema
                    System.out.println("¿Cuántos usuarios quiere agregar?");
                    int cantidadUsuarios = entrada.nextInt();
                    entrada.nextLine(); // Consumir el salto de línea

                    for (int i = 0; i < cantidadUsuarios; i++) {
                        System.out.println("Ingrese nombre del usuario " + (i + 1) + ": ");
                        String nombre = entrada.nextLine();

                        System.out.println("Ingrese identificación (cedula) del usuario " + (i + 1) + ": ");
                        String identificacion = entrada.nextLine();

                        System.out.println("Ingrese email del usuario " + (i + 1) + ": ");
                        String email = entrada.nextLine();

                        // Crear un nuevo objeto Usuario y registra en la biblioteca
                        Usuario nuevoUsuario = new Usuario(nombre, identificacion, email);
                        biblioteca.registrarUsuario(nuevoUsuario);
                    }
                    System.out.println("¿Desea ver la lista de usuarios? (Sí/No)");
                    String respuesta2 = entrada.nextLine();

                    // Verificar la respuesta del usuario
                    if (respuesta2.trim().equalsIgnoreCase("si")) {
                        // Mostrar la lista completa de usuarios
                        System.out.println("Lista completa de usuarios:");
                        for (Usuario usuario : biblioteca.getListaUsuarios()) {
                            usuario.mostrarInformacion();
                            System.out.println("-----------------------------------------");
                        }
                    } else {
                        System.out.println("No se mostrará la lista de usuarios.");
                    }
                    break;

    			case 3:
    				// Pide al usuario el ingreso del titulo de libro
    			    System.out.print("Ingrese el título del libro a buscar: ");
    			    
    			    // Leer el título del libro que fue agregado
    			    String tituloBuscado = entrada.nextLine();
    			    
    			    // Llama al método de la biblioteca para buscar el libro por el título agregado anteriormente
    			    Libro libroEncontrado = biblioteca.buscarLibro(tituloBuscado);

    			    // Verificar si se encontró el libro
    			    if (libroEncontrado != null) {
    			        // Mostrar la información del libro encontrado
    			        libroEncontrado.mostrarInformacion();
    			    } else {
    			        // Imprime un mensaje que el libro no fue encontrado
    			        System.out.println("Libro no encontrado.");
    			    }
    			    break;

    			case 4:
    				System.out.println("Usuarios a los que se puede prestar:");
    				for (int i = 0; i < biblioteca.getListaUsuarios().size(); i++) {
    				    Usuario usuario = biblioteca.getListaUsuarios().get(i);
    				    System.out.println((i + 1) + ". " + usuario.getNombre());
    				}

    				// Solicitar al usuario seleccionar un usuario
    				System.out.print("Seleccione el número del usuario al que desea prestar libros: ");
    				int numeroUsuario = entrada.nextInt();
    				entrada.nextLine(); // Consumir la nueva línea

    				// Verificar si el número seleccionado es válido
    				if (numeroUsuario > 0 && numeroUsuario <= biblioteca.getListaUsuarios().size()) {
    				    Usuario usuarioSeleccionado = biblioteca.getListaUsuarios().get(numeroUsuario - 1);

    				    // Solicitar al usuario la cantidad de libros que desea pedir prestados
    				    System.out.print("Ingrese la cantidad de libros que desea pedir prestados: ");
    				    int cantidadDeLibros = entrada.nextInt();
    				    entrada.nextLine(); // Consumir la nueva línea

    				    // Mostrar lista de libros disponibles y permitir al usuario seleccionar
    				    System.out.println("Seleccione los libros que desea pedir prestados:");
    				    ArrayList<Libro> librosDisponibles = biblioteca.obtenerLibrosDisponibles();
    				    for (int i = 0; i < librosDisponibles.size(); i++) {
    				        Libro libro = librosDisponibles.get(i);
    				        System.out.println((i + 1) + ". " + libro.getTitulo() + " - Disponible: " + (libro.isDisponible() ? "Sí" : "No"));
    				    }

    				    // Solicitar al usuario seleccionar libros
    				    ArrayList<Libro> librosSeleccionados = new ArrayList<>();
    				    for (int i = 0; i < cantidadDeLibros; i++) {
    				        System.out.print("Seleccione el número del libro " + (i + 1) + ": ");
    				        int numeroLibro = entrada.nextInt();
    				        entrada.nextLine(); // Consumir la nueva línea

    				        // Verificar si el número seleccionado es válido
    				        if (numeroLibro > 0 && numeroLibro <= librosDisponibles.size()) {
    				            Libro libroSeleccionado = librosDisponibles.get(numeroLibro - 1);
    				            librosSeleccionados.add(libroSeleccionado);
    				        } else {
    				            System.out.println("Número de libro no válido. Ignorando el libro con número: " + numeroLibro);
    				        }
    				    }

    				    // Realizar los préstamos
    				    for (Libro libro : librosSeleccionados) {
    				        biblioteca.prestarLibro(libro, usuarioSeleccionado);
    				    }

    				    // Imprimir información sobre los préstamos
    				    System.out.println("Préstamos realizados con éxito:");
    				    System.out.println("Libros prestados:");
    				    for (Libro libro : librosSeleccionados) {
    				        System.out.println("- " + libro.getTitulo());
    				    }
    				    System.out.println("Usuario:");
    				    usuarioSeleccionado.mostrarInformacion();
    				} else {
    				    System.out.println("Número de usuario no válido.");
    				}break;
    			case 5:
    				
    				System.out.println("Lista de préstamos:");
    			    // Imprimir la lista de préstamos
    			    for (Prestamo prestamo : biblioteca.getListaPrestamos()) {
    			        System.out.println("Libro: " + prestamo.getLibro().getTitulo());
    			        System.out.println("Usuario: " + prestamo.getUsuario().getNombre() 
    			        		+"con numero de cedula: "+prestamo.getUsuario().getIdentificacion());
    			        System.out.println("Fecha de préstamo: " + prestamo.getFechaPrestamo());
    			        System.out.println("Fecha maxima a devolver: " + prestamo.getFechaDeVolucion());
    			        System.out.println("-----------------------------------------");
    			    }

    			    // Pedir al usuario que ingrese el título del libro a devolver
    			    System.out.print("Ingrese el título del libro a devolver: ");
    			    String tituloLibroADevolver = entrada.nextLine();

    			    // Buscar el libro en la lista de préstamos
    			    Prestamo prestamoADevolver = biblioteca.buscarPrestamoPorLibro(tituloLibroADevolver);

    			    // Verificar si se encontró el libro y si el préstamo es vigente
    			    if (prestamoADevolver != null && prestamoADevolver.esPrestamoVigente()) {
    			        // Devolver el libro
    			        biblioteca.devolverLibro(prestamoADevolver);

    			        // Imprimir mensaje de éxito
    			        System.out.println("Libro devuelto con éxito: " + prestamoADevolver.getLibro().getTitulo());
    			    } else {
    			        // Imprimir mensaje de error si no se encontró el libro o el préstamo no es vigente
    			        System.out.println("Error al devolver el libro. Verifique que el libro esté prestado y verifique"
    			        			+" su fecha de devolucion");
    			    }
    			    break;

                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor intente de nuevo.");
            }
        } while (opcion != 6);

        // Cerrar el objeto Scanner al salir del programa
        entrada.close();
    }
}
