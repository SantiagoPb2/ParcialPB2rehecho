package parcialRehecho;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.Biblioteca;
import ar.edu.unlam.pb2.Estudiante;
import ar.edu.unlam.pb2.Geografia;
import ar.edu.unlam.pb2.Historia;
import ar.edu.unlam.pb2.Libro;
import ar.edu.unlam.pb2.Matematica;

public class Prueba {

	@Test
	public void queSePuedaImprimirUnLibro() {
		Libro libro = new Geografia(010,"Nombre","Autor");
		Libro libro1 = new Historia(011,"Nombre","Autor");
		
		assertEquals("Soy un libro de Geografia",libro.imprimir());
		assertEquals("Soy un libro de Historia",libro1.imprimir());
	}
	
	@Test
	public void queSePuedaPrestarUnLibro() {
		Libro libro = new Historia(12,"NombreLibro","Santiago");
		Libro libro1 = new Geografia(11,"Nombre","Santiago");
		Estudiante estudiante = new Estudiante(41399474,"Fernandez","Santiago");
		Biblioteca biblioteca = new Biblioteca("Azteca");
		biblioteca.agregarLibro(libro);
		biblioteca.agregarLibro(libro1);
		biblioteca.agregarEstudiante(estudiante);
		
		assertTrue(biblioteca.prestarLibro(12,41399474));
	}
	
	@Test
	public void queSePuedaDevolverUnLibro(){
		Libro libro = new Historia(12,"NombreLibro","Santiago");
		Libro libro1 = new Geografia(11,"Nombre","Santiago");
		Estudiante estudiante = new Estudiante(41399474,"Fernandez","Santiago");
		Biblioteca biblioteca = new Biblioteca("Azteca");
		biblioteca.agregarLibro(libro);
		biblioteca.agregarLibro(libro1);
		biblioteca.agregarEstudiante(estudiante);
		biblioteca.prestarLibro(12,41399474);

		
		assertTrue(biblioteca.devolverLibro(12, 41399474));
		
	}
	
	@Test
	public void queNoSePuedaPrestarUnLibroaUnEstudianteConMasDeDosLibros() {
		Libro libro = new Historia(12,"NombreLibro","Santiago");
		Libro libro1 = new Geografia(11,"Nombre","Santiago");
		Libro libro2 = new Matematica(9,"Nombre","Santiago");		
		Estudiante estudiante = new Estudiante(41399474,"Fernandez","Santiago");
		Biblioteca biblioteca = new Biblioteca("Azteca");
		biblioteca.agregarLibro(libro);
		biblioteca.agregarLibro(libro1);
		biblioteca.agregarLibro(libro2);
		biblioteca.agregarEstudiante(estudiante);
		biblioteca.prestarLibro(11,41399474);
		biblioteca.prestarLibro(12,41399474);


		
		assertFalse(biblioteca.prestarLibro(9,41399474));
			
	}
	
	@Test
	public void queElIndicadorDePrestamosSeaCorrecto() {
		Libro libro = new Historia(12,"NombreLibro","Santiago");
		Libro libro1 = new Geografia(11,"Nombre","Santiago");
		Libro libro2 = new Matematica(9,"Nombre","Santiago");		
		Estudiante estudiante = new Estudiante(41399474,"Fernandez","Santiago");
		Biblioteca biblioteca = new Biblioteca("Azteca");
		biblioteca.agregarLibro(libro);
		biblioteca.agregarLibro(libro1);
		biblioteca.agregarLibro(libro2);
		biblioteca.agregarEstudiante(estudiante);
		biblioteca.prestarLibro(11,41399474);
		biblioteca.prestarLibro(12,41399474);
		biblioteca.prestarLibro(9,41399474);
		
		assertEquals(2,biblioteca.getPrestamosRealizados(),0);
		
	}
	
	@Test
	public void queAlPrestarUnLibroEsteNoEsteDisponible() {
		Libro libro = new Historia(12,"NombreLibro","Santiago");
		Estudiante estudiante = new Estudiante(41399474,"Fernandez","Santiago");
		Biblioteca biblioteca = new Biblioteca("Azteca");
		biblioteca.agregarLibro(libro);
		biblioteca.agregarEstudiante(estudiante);
		biblioteca.prestarLibro(12,41399474);
		
		assertFalse(biblioteca.getDisponibilidad(12));
	}
	
	@Test
	public void queSePuedaImprimirUnLibroDesdeLaBiblioteca() {
		Libro libro = new Historia(12,"NombreLibro","Santiago");
		Biblioteca biblioteca = new Biblioteca("Azteca");
		biblioteca.agregarLibro(libro);
		
		
		assertEquals("Soy un libro de Historia",biblioteca.impresionBiblioteca(12));
	}
}
