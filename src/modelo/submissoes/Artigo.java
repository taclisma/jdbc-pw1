package modelo.submissoes;

import java.util.Date;

public class Artigo extends Submissao{
	private String abstrato;
	private String resumo;
	private String arquivo;
	
	public Artigo() {};	
	public Artigo(String titulo, Date data, String abstrato, String resumo, String arquivo) {
		super(titulo, data);
		this.abstrato = abstrato;
		this.resumo = resumo;
		this.arquivo = arquivo;
	}


	@Override
	public String toString() {
		return super.toString() + "Artigo [abstrato=" + abstrato + ", resumo=" + resumo + ", arquivo=" + arquivo + ", toString()="
				+ "]";
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
