package ups.edu.ec.clases;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;

public class Prestamo {
    private Libro libro;
    private Usuario usuario;			//Atributos de la clase Prestamo
    private LocalDate fechaPrestamo;
    private LocalDate fechaDeVolucion;

    public Prestamo(Libro libro, Usuario usuario) {
    	//Constructor de la clase prestamo con los parametros libro , usuario,decha prestam
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = LocalDate.now();
        this.calcularDiasPrestamo(); // Llama automáticamente al método al crear el objeto
    }


	//metodos de encapsulamiento
    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDeVolucion() {
        return fechaDeVolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDeVolucion) {
        this.fechaDeVolucion = fechaDeVolucion;
    }

    //metodo para calcularDiasPrestamo
    public LocalDate calcularDiasPrestamo() {
        // Sumar 30 días a la fecha de préstamo
        fechaDeVolucion = fechaPrestamo.plusDays(30);
        return fechaDeVolucion;
    }

    //metodo esPrestamoVigente
    public boolean esPrestamoVigente() {
        // Obtén la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Calcula la diferencia en días entre la fecha de devolución y la fecha actual
        long diferenciaEnDias = fechaDeVolucion.toEpochDay() - fechaActual.toEpochDay();

        // Verifica si la diferencia es positiva y menor o igual a 30 días
        return diferenciaEnDias > 0 && diferenciaEnDias <= 30;
    }
}