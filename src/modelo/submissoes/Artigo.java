package modelo.submissoes;

import java.util.Date;
import java.util.TreeSet;

import modelo.pessoas.Autor;
import modelo.util.Situacao;

public class Artigo extends Submissao{
	private String abstrato;
	private String resumo;
	private String arquivo;
	
	public Artigo() { super(); };	
	public Artigo(String titulo, Date data, TreeSet<Autor> autores, String abstrato, String resumo, String arquivo, Situacao situacao) {
		super(titulo, data, autores, situacao);
		this.abstrato = abstrato;
		this.resumo = resumo;
		this.arquivo = arquivo;
	}


	@Override
	public String toString() {
		return super.toString() + "Artigo \n\tAbstrato: " + abstrato + "\n\tResumo: " + resumo + "\n\tArquivo: " + arquivo + "\n";
	}
	
	public String getAbstrato() {
		return abstrato;
	}
	public void setAbstrato(String abstrato) {
		this.abstrato = abstrato;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public String getArquivo() {
		return arquivo;
	}
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	
}
