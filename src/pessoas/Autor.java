package pessoas;

import contatos.Telefone;

public class Autor {
	private String nome;
	private String email;
	private Telefone telefone;
	
	public Autor() {};
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
		return "-----------\nAutor: \n\tnome=" + nome + " \n\temail=" + email + "\n\ttelefone" + telefone + "\n-----------";
	}
	
}
