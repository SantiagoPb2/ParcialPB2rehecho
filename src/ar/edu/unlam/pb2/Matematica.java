package ar.edu.unlam.pb2;

public class Matematica extends Libro {
	private Boolean fotocopiable;
	
	public Matematica(Integer codigo, String nombreLibro, String autor) {
		super(codigo,nombreLibro,autor);
		this.fotocopiable = Boolean.FALSE;
	}

	public Boolean getFotocopiable() {
		return fotocopiable;
	}
	
	public String imprimir() {
		String fotocopia = "No se puede imprimir";
		if(this.fotocopiable.equals(Boolean.TRUE)){
			fotocopia = "Soy un libro de Matematica";
			return fotocopia;
		}
		return fotocopia;	
	}
}
