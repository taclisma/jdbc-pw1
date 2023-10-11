package modelo.pessoas;

import java.util.Objects;

import modelo.contatos.Telefone;

public class Autor implements Comparable<Autor>{
	private String nome;
	private String email;
	private Telefone telefone;
	
	public Autor() {};
	public Autor(String nome) {
		this.nome = nome;
	}
	public Autor(String nome, String email, Telefone telefone) {
		this.nome = nome;
		this.email = email;
		this.setTelefone(telefone);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Telefone getTelefone() {
		return telefone;
	}
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public String toString() {
		return "\tNome: " + nome + " \n\tEmail: " + email + "\n\tTelefone: " + telefone + "\n";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return Objects.equals(email, other.email) && Objects.equals(nome, other.nome);
	}
	@Override
	public int compareTo(Autor o) {
		return getNome().compareToIgnoreCase(o.getNome());
	}

	

	
	
}
