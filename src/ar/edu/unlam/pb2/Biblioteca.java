package ar.edu.unlam.pb2;

import java.util.LinkedList;
import java.util.List;

public class Biblioteca {
	
	private List<Libro> libros;
	private List<Estudiante> estudiantes;
	private List<Prestamo> librosPrestados;
	private String nombre;
	private Integer prestamosRealizados;
	private Integer id = 0;
	
	public Biblioteca(String nombre) {
		this.nombre = nombre;
		this.libros = new LinkedList<Libro>();
		this.estudiantes = new LinkedList<Estudiante>();
		this.librosPrestados = new LinkedList<Prestamo>();
		this.prestamosRealizados = 0;
	}
	
	public void agregarLibro(Libro libro) {
		this.libros.add(libro);
	}
	
	public void agregarEstudiante(Estudiante estudiante) {
		this.estudiantes.add(estudiante);
	}
	
	public Boolean getDisponibilidad(Integer codigo) {
		for(Libro libros: libros) {
			if(libros.getCodigo().equals(codigo)) {
				return true;
			}
		}
		return false;
		
	}
	
	public Boolean prestarLibro(Integer codigoLibro,Integer dni) {
		for(Libro busqueda: libros) {
			if(busqueda.getCodigo().equals(codigoLibro)) {
				for(Estudiante busqueda2: estudiantes) {
					if(busqueda2.getDni().equals(dni) && busqueda2.getLibrosEnPosesion() < 2) {
						Prestamo prestamos = new Prestamo(id++,busqueda2.getNombre(),codigoLibro);
						prestamos.agregarLibroPrestado(busqueda);
						busqueda2.tomarPrestadoLibro(busqueda);
						this.librosPrestados.add(prestamos);
						this.libros.remove(busqueda);
						this.prestamosRealizados++;
						return Boolean.TRUE;
					}
				}
			}
		}
		
		return Boolean.FALSE;
	}
	
	public Boolean devolverLibro(Integer codigoLibro, Integer dni) {
		for(Prestamo busqueda: librosPrestados) {
			if(busqueda.getCodigoLibro().equals(codigoLibro)) {
				for(Estudiante busqueda2: estudiantes) {
					if(busqueda2.getDni().equals(dni) && busqueda2.getLibrosEnPosesion() >= 1) {
						Libro libroDevuelto = busqueda.getLibrosPrestados(codigoLibro);
						busqueda2.devolverLibroPrestado(libroDevuelto);
						this.libros.add(libroDevuelto);
						this.librosPrestados.remove(busqueda);
						return Boolean.TRUE;
					}
				}
			}
		}
		return Boolean.FALSE;
	}
	
	public Integer getPrestamosRealizados() {
		return prestamosRealizados;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String impresionBiblioteca(Integer codigo) {
		String impresion = "";
		for(Libro busqueda: libros) {
			if(busqueda.getCodigo().equals(codigo)) {
				impresion = busqueda.imprimir();
				return impresion;
			}
		}
		return impresion;
	}
	
}	
