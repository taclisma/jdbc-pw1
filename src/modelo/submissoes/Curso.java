package modelo.submissoes;

import java.util.Date;

public class Curso extends Submissao{
	private String justificativa;
	private String material;
	private String objetivo;
	private double duracao;
	
	public Curso(String titulo, Date data, String justificativa, String material, String objetivo, double duracao) {
		super(titulo, data);
		this.justificativa = justificativa;
		this.material = material;
		this.objetivo = objetivo;
		this.duracao = duracao;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Curso [justificativa=" + justificativa + ", material=" + material + ", objetivo=" + objetivo
				+ ", duracao=" + duracao + ", toString()=" + "]";
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
