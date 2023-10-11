package view;

import java.util.TreeSet;

import javax.swing.JOptionPane;

import modelo.pessoas.Autor;
import modelo.submissoes.Submissao;

public class Inicio {
	public static void main(String[] args) {
		
		TreeSet<Submissao> submissoes = new TreeSet<Submissao>();
		TreeSet<Autor> autores = new TreeSet<Autor>();

		
		while (true) {
			switch(Menu.montaMenuInicial()) {
			case 1:// Cadastrar Submissão
				try{
					if (submissoes.add(Menu.cadastraSubmissao(autores))){
						JOptionPane.showMessageDialog(null, "inserido com sucesso");
					}
				} catch	(NullPointerException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro desconhecido encontrado: \n" + e.getMessage());
					e.printStackTrace();					
				}
				break;
				
				
			case 2: // Pesquisar Submissão pela data
					Menu.buscaSumissaoPorData(submissoes);
				break;
				
				
			case 3: // Cadastrar autor
				try {
					if (autores.add(Menu.cadastraAutor())) {
						JOptionPane.showMessageDialog(null, "inserido com sucesso");
					}
				} catch	(NullPointerException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro desconhecido encontrado: \n" + e.getMessage());
					e.printStackTrace();					}
				break;
				
				
			case 4: // Pesquisar autor pelo nome
				if (autores.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Sem autores cadastrados", "Autores\n", 3);
					break;
				}
				Autor auxB = Menu.buscaAutorPorNome(JOptionPane.showInputDialog("Busca por nome do autor: "), autores);
				if (auxB != null)
					JOptionPane.showMessageDialog(null, "Encontrado autor: \n" + auxB);
				else 
					JOptionPane.showInputDialog("Autor nao encontrado");

					
				break;
				
				
			case 5: // Listar todas as Submissões
				if (submissoes.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Sem submissões cadastradas", "Submissoes\n", 3);
					break;
				}
				
				String auxS = "----\n";
				for (Submissao sub: submissoes) {
					auxS += sub + "\n----\n";
				}
				JOptionPane.showMessageDialog(null, auxS, "Submissoes\n", 3);
				break;
				
				
			case 6: // Listar todos os autores
				if (autores.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Sem autores cadastradas", "Autores\n", 3);
					break;
				}
				
				String auxA = "----\n";
				for (Autor aut: autores) {
					auxA += aut + "\n----\n";
				}
				JOptionPane.showMessageDialog(null, auxA, "Autores\n", 3);
				break;
				
			case 7:
				System.exit(0);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção invalida");
				break;
			}
		}
	}
}
