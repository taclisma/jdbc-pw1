package modelo.submissoes;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.TreeSet;

import modelo.pessoas.Autor;
import modelo.util.Situacao;
import modelo.util.Validador;

public abstract class Submissao implements Validador, Comparable<Submissao>{
	
	private static int total;

	private Situacao situacao;
	private TreeSet<Autor> autores;
	private String titulo;
	private Date data; //A data da Submissão deve ser validada usando a interface Validador
	
	public Submissao() {total++;};
	public Submissao(String titulo, Date data, TreeSet<Autor> autores,Situacao situacao) {
		total++;
		this.titulo = titulo;
		this.data = data;
		this.autores = autores;
		this.situacao = situacao;
	}
	
	public TreeSet<Autor> getAutores() {
		return autores;
	}
	public void setAutores(TreeSet<Autor> autores) {
		this.autores = autores;
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
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	public void addAutor(Autor autor) {
		this.autores.add(autor);
	}
	
	public static int getTotal() {
		return total;
	}
	
	
	@Override
	public boolean validarData(Date data) {
		if (data != null && data.before(new Date())) {
            return true;
        } else {
        	throw new IllegalArgumentException("Data invalida");
        }
	}
	

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		String aux = "";
		if (autores != null && !autores.isEmpty()) {
			for (Autor autor : autores) {
				aux += (autor.getNome() + ", ");
				
			}
		}
		
		return "\n\tTítulo: " + titulo + (autores != null ? ("\n\tAutores: \n\t" + aux) : "\n\tSem autores cadastrados" ) + "\n\tData: " + (data != null ? sdf.format(data) : "Sem data cadastrada")
				+ " Situação: " + situacao.getDescricao() + "\n\t";
	}
	@Override
	public int hashCode() {
		return Objects.hash(data, titulo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Submissao other = (Submissao) obj;
		return Objects.equals(data, other.data) && Objects.equals(titulo, other.titulo);
	}
	
	@Override
	public int compareTo(Submissao o) {
		return getTitulo().compareToIgnoreCase(o.getTitulo());
	}
	
}
