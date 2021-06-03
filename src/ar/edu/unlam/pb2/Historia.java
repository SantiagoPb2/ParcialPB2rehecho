package ar.edu.unlam.pb2;

public class Historia extends Libro {
	
	private Boolean fotocopiable;

	public Historia(Integer codigo, String nombreLibro, String autor) {
		super(codigo,nombreLibro,autor);
		this.fotocopiable = Boolean.TRUE;
	}
	
	public Boolean getFotocopiable() {
		return fotocopiable;
	}
	
	@Override
	public String imprimir() {
		String impresion = "No se puede imprimir";
		if(this.fotocopiable.equals(Boolean.TRUE)){
			impresion = "Soy un libro de Historia";
			return impresion;
		}
		return impresion;
	}

}
