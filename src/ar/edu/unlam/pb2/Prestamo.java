package ar.edu.unlam.pb2;

import java.util.LinkedList;
import java.util.List;

public class Prestamo {
	
	private Integer id;
	private String alumno;
	private Integer codigoLibro;
	private List<Libro> librosPrestados;
	
	public Prestamo(Integer id, String alumno, Integer codigoLibro) {
		this.id = id;
		this.alumno = alumno;
		this.codigoLibro = codigoLibro;
		this.librosPrestados = new LinkedList<Libro>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAlumno() {
		return alumno;
	}

	public void setAlumno(String alumno) {
		this.alumno = alumno;
	}

	public Integer getCodigoLibro() {
		return codigoLibro;
	}

	public void setCodigoLibro(Integer codigoLibro) {
		this.codigoLibro = codigoLibro;
	}

	public Libro getLibrosPrestados(Integer codigoLibro) {
		Libro prestado = null;
		for(Libro libros: librosPrestados) {
			if(libros.getCodigo().equals(codigoLibro)){
				prestado = libros;
				return prestado;
			}
		}
		return prestado;
	}
	
	public void agregarLibroPrestado(Libro libro) {
		this.librosPrestados.add(libro);
	}
	

}
