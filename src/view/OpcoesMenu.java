package view;

public enum OpcoesMenu {
	CAD_SUB(1, "Cadastrar Submissão"), 
	PESQ_SUB_DATA(2, "Pesquisar Submissão pela data"), 
	CAD_AUTOR(3, "Cadastrar autor"),
	PESQ_AUTOR_NOME(4, "Pesquisar autor pelo nome"),
	LISTAR_TODOS_SUB(5, "Listar todas as Submissões"),
	LISTAR_TODOS_AUTOR(6, "Listar todos os autores"),
	SAIR(7, "Sair");

	private final int valor;
	private final String descricao;

	private OpcoesMenu(int valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public int getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getItem() {
		return this.getValor() + " - " + this.getDescricao();
	}
}
