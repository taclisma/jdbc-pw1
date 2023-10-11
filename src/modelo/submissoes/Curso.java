package modelo.submissoes;

import java.util.Date;
import java.util.TreeSet;

import modelo.pessoas.Autor;
import modelo.util.Situacao;

public class Curso extends Submissao{
	private String justificativa;
	private String material;
	private String objetivo;
	private double duracao;
	
	public Curso() { super(); };
	public Curso(String titulo, Date data, TreeSet<Autor> autores, String justificativa, String material, String objetivo, double duracao, Situacao situacao) {
		super(titulo, data, autores, situacao);
		this.justificativa = justificativa;
		this.material = material;
		this.objetivo = objetivo;
		this.duracao = duracao;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Curso \n\tJustificativa: " + justificativa + "\n\tMaterial: " + material + "\n\tObjetivo: " + objetivo
				+ "\n\tDuração: " + duracao + "\n";
	}
	
	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public double getDuracao() {
		return duracao;
	}

	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}
	
}
