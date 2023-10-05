package modelo.submissoes;
import java.util.Date;

import modelo.util.Validador;

public class Submissao implements Validador{
	
	private static int total;

	private Situacao situacao;
	private String titulo;
	private Date data;
	
	public Submissao() {total++;};
	public Submissao(String titulo, Date data) {
		total++;
		
		this.titulo = titulo;
		this.data = data;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	public static int getTotal() {
		return total;
	}
	@Override
	public boolean validarData() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "Submissao: \nTítulo: " + titulo + "\nData: " + data;
	}
	
}
